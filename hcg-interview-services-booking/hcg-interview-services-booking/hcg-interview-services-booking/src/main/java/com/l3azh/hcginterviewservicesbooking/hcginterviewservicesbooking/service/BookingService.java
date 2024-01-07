package com.l3azh.hcginterviewservicesbooking.hcginterviewservicesbooking.service;

import com.l3azh.hcginterviewservicesbooking.hcginterviewservicesbooking.dto.BookRoomRequestDto;
import com.l3azh.hcginterviewservicesbooking.hcginterviewservicesbooking.dto.base.BaseResponseDto;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingService {
    BaseResponseDto<Object> bookingRoom(BookRoomRequestDto bookRoomRequestDto);
}
