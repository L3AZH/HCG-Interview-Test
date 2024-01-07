package com.l3azh.hcginterviewservicesbooking.hcginterviewservicesbooking.service;

import com.l3azh.hcginterviewservicesbooking.hcginterviewservicesbooking.dao.BookingDao;
import com.l3azh.hcginterviewservicesbooking.hcginterviewservicesbooking.dto.BookRoomRequestDto;
import com.l3azh.hcginterviewservicesbooking.hcginterviewservicesbooking.dto.RoomRateAndAvailabilityDto;
import com.l3azh.hcginterviewservicesbooking.hcginterviewservicesbooking.dto.RoomRateDto;
import com.l3azh.hcginterviewservicesbooking.hcginterviewservicesbooking.dto.base.BaseResponseDto;
import com.l3azh.hcginterviewservicesbooking.hcginterviewservicesbooking.entity.BookingEntity;
import com.l3azh.hcginterviewservicesbooking.hcginterviewservicesbooking.util.AmqProducer;
import com.l3azh.hcginterviewservicesbooking.hcginterviewservicesbooking.service.external.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private InventoryService.GetRoomRateAndAvailability roomRateAndAvailability;
    @Autowired
    private BookingDao bookingDao;
    @Autowired
    private AmqProducer amqProducer;

    @Override
    public BaseResponseDto<Object> bookingRoom(BookRoomRequestDto bookRoomRequestDto) {
        //This logic doesn't care about which hotel from booking request also
        // the number of booking room( this logic tread the number is 1)
        // , should be improved this logic and DB
        BaseResponseDto<List<RoomRateAndAvailabilityDto>> roomInfoResponse =
                roomRateAndAvailability.getRoomRateAndRoomAvailability(bookRoomRequestDto.getStartDate(), bookRoomRequestDto.getEndDate());
        List<RoomRateAndAvailabilityDto> roomInfoData = roomInfoResponse.getData();
        if (roomInfoData.isEmpty())
            return BaseResponseDto.builder()
                    .code(HttpStatus.NO_CONTENT.value())
                    .flag(false).data("No room available!").build();
        long numberOfDays = calculateNumberOfDay(bookRoomRequestDto.getStartDate(), bookRoomRequestDto.getEndDate());
        if (roomInfoData.size() < numberOfDays)
            return BaseResponseDto.builder()
                    .code(HttpStatus.BAD_REQUEST.value())
                    .flag(false).data("Not enough room available, please adjust your time").build();
        //calculate price
        BigDecimal totalPrice = new BigDecimal(0);
        List<BigDecimal> listPrice = new ArrayList<>();
        roomInfoData.forEach(roomInfo -> {
            Optional<RoomRateDto> roomRateDto =
                    roomInfo.getRoomRate().stream()
                            .filter(
                                    romRate -> bookRoomRequestDto.getRatePlanId().equals(romRate.getRatePlanId())
                            ).findFirst();
            if (roomRateDto.isPresent()) {
                listPrice.add(roomRateDto.get().getPrice());
            } else {
                // This one is wrong logic, because when rate plan does not apply for this date so the price should
                // back to the default price and the default rate plan come along with room rate but time is running out
                listPrice.add(roomInfo.getRoomRate().get(0).getPrice());
            }
        });
        for (BigDecimal price : listPrice) {
            totalPrice = totalPrice.add(price);
        }
        BookingEntity newBokBookingEntity = BookingEntity.builder()
                .guestEmail(bookRoomRequestDto.getGuestEmail())
                .roomTypeId(bookRoomRequestDto.getRoomTypeId())
                .ratePlanId(bookRoomRequestDto.getRatePlanId())
                .price(totalPrice).build();
        bookingDao.save(newBokBookingEntity);
        /**
         * Send Update action
         */
        amqProducer.sendMessage("update_req.queue",amqProducer.gson.toJson(bookRoomRequestDto));
        return BaseResponseDto.builder()
                .code(HttpStatus.OK.value())
                .flag(true).data("New Booking is created").build();
    }

    private long calculateNumberOfDay(String startDate, String endDate) {
        LocalDate startDateLoc = LocalDate.parse(startDate);
        LocalDate endDateLoc = LocalDate.parse(endDate);
        return ChronoUnit.DAYS.between(startDateLoc, endDateLoc);
    }
}
