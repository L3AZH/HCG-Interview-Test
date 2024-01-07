package com.l3azh.hcginterviewservicesbooking.hcginterviewservicesbooking.controller;

import com.l3azh.hcginterviewservicesbooking.hcginterviewservicesbooking.dto.BookRoomRequestDto;
import com.l3azh.hcginterviewservicesbooking.hcginterviewservicesbooking.dto.base.BaseResponseDto;
import com.l3azh.hcginterviewservicesbooking.hcginterviewservicesbooking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/booking")
    public ResponseEntity<BaseResponseDto<Object>> bookingRoom(@RequestBody BookRoomRequestDto bookRoomRequestDto){
        return ResponseEntity.ok(bookingService.bookingRoom(bookRoomRequestDto));
    }
}
