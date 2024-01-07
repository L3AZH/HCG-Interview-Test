package com.l3azh.hcginterviewservicesinventory.hcginterviewservicesinventory.service;

import com.l3azh.hcginterviewservicesinventory.hcginterviewservicesinventory.dao.RoomAvailabilityDao;
import com.l3azh.hcginterviewservicesinventory.hcginterviewservicesinventory.dao.RoomRateDao;
import com.l3azh.hcginterviewservicesinventory.hcginterviewservicesinventory.dao.RoomTypeDao;
import com.l3azh.hcginterviewservicesinventory.hcginterviewservicesinventory.dto.RoomAvailabilityDto;
import com.l3azh.hcginterviewservicesinventory.hcginterviewservicesinventory.dto.RoomRateAndAvailabilityDto;
import com.l3azh.hcginterviewservicesinventory.hcginterviewservicesinventory.dto.RoomRateDto;
import com.l3azh.hcginterviewservicesinventory.hcginterviewservicesinventory.dto.base.BaseResponseDto;
import com.l3azh.hcginterviewservicesinventory.hcginterviewservicesinventory.entity.RatePlanEntity;
import com.l3azh.hcginterviewservicesinventory.hcginterviewservicesinventory.entity.RoomTypeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private RoomTypeDao roomTypeDao;
    @Autowired
    private RoomAvailabilityDao roomAvailabilityDao;
    @Autowired
    private RoomRateDao roomRateDao;

    @Autowired
    private SimpleDateFormat df;

    @Override
    public BaseResponseDto<List<RoomRateAndAvailabilityDto>> getRoomRateAndRoomAvailability(String startDate, String endDate) {
        //List<RoomTypeEntity> roomTypeEntity = roomTypeDao.findAll();
        Map<String, RoomRateAndAvailabilityDto> mapResult = new HashMap<>();
        // get Room Availability
        roomAvailabilityDao.findFromDateToDate(startDate, endDate).forEach(roomAvailabilityEntity -> {
            String dateString = df.format(roomAvailabilityEntity.getDate());
            if (mapResult.containsKey(dateString)) {
                RoomRateAndAvailabilityDto oldValue = mapResult.get(dateString);
                oldValue.getRoomAvailability().add(RoomAvailabilityDto.builder()
                        .roomTypeId(roomAvailabilityEntity.getRoomTypeEntity().getId())
                        .availableToSell(roomAvailabilityEntity.getAvailableToSell()).build());
            } else {
                mapResult.put(dateString, RoomRateAndAvailabilityDto.builder()
                        .date(roomAvailabilityEntity.getDate()).build());
                List<RoomAvailabilityDto> roomAvailabilityDtoList = new ArrayList<>();
                roomAvailabilityDtoList.add(RoomAvailabilityDto.builder()
                        .roomTypeId(roomAvailabilityEntity.getRoomTypeEntity().getId())
                        .availableToSell(roomAvailabilityEntity.getAvailableToSell()).build());
                mapResult.get(dateString).setRoomAvailability(roomAvailabilityDtoList);
            }
        });
        // get Room Rate
        roomRateDao.findFromDateToDate(startDate, endDate).forEach(roomRateEntity -> {
            String dateString = df.format(roomRateEntity.getDate());
            if (!mapResult.containsKey(dateString)) {
                mapResult.put(dateString, RoomRateAndAvailabilityDto.builder().build());
            }

            RoomRateAndAvailabilityDto oldValue = mapResult.get(dateString);
            if (oldValue.getRoomRate() == null) oldValue.setRoomRate(new ArrayList<>());
            List<RoomRateDto> roomRateDtoList = oldValue.getRoomRate();
            // handle rate plan default of room rate
            roomRateEntity.getRatePlanEntity().getPeriodEntityList().forEach(periodEntity -> {
                if (periodEntity.getStartDate().before(roomRateEntity.getDate()) &&
                        periodEntity.getEndDate().after(roomRateEntity.getDate())) {
                    roomRateDtoList.add(RoomRateDto.builder()
                            .roomTypeId(roomRateEntity.getRoomTypeEntity().getId())
                            .ratePlanId(roomRateEntity.getRatePlanEntity().getId())
                            .price(roomRateEntity.getPrice()).build());
                }
            });
            // handle rate plan which room type is applied
            Optional<RoomTypeEntity> roomTypeEntityOptional = roomTypeDao.findById(roomRateEntity.getRoomTypeEntity().getId());
            if (roomTypeEntityOptional.isPresent()) {
                RoomTypeEntity roomTypeEntity = roomTypeEntityOptional.get();
                List<RatePlanEntity> ratePlanEntityList = roomTypeEntity.getRatePlanEntityList();
                ratePlanEntityList.forEach(ratePlanEntity -> {
                    ratePlanEntity.getPeriodEntityList().forEach(periodEntity -> {

                        if (periodEntity.getStartDate().before(roomRateEntity.getDate()) &&
                                periodEntity.getEndDate().after(roomRateEntity.getDate())) {
                            roomRateDtoList.add(RoomRateDto.builder()
                                    .roomTypeId(roomRateEntity.getRoomTypeEntity().getId())
                                    .ratePlanId(ratePlanEntity.getId())
                                    .price(roomRateEntity.getPrice()).build());
                        }
                    });
                });
            }

        });
        return BaseResponseDto.<List<RoomRateAndAvailabilityDto>>builder()
                .code(HttpStatus.OK.value())
                .flag(true)
                .data(mapResult.values().stream().toList()).build();
    }

}
