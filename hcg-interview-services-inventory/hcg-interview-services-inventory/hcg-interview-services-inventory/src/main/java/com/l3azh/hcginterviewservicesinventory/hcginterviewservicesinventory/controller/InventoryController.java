package com.l3azh.hcginterviewservicesinventory.hcginterviewservicesinventory.controller;

import com.l3azh.hcginterviewservicesinventory.hcginterviewservicesinventory.dto.RoomRateAndAvailabilityDto;
import com.l3azh.hcginterviewservicesinventory.hcginterviewservicesinventory.dto.base.BaseResponseDto;
import com.l3azh.hcginterviewservicesinventory.hcginterviewservicesinventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/getRoomRateAndAvailability")
    public ResponseEntity<BaseResponseDto<List<RoomRateAndAvailabilityDto>>> getRoomRateAndAvailability(
            @RequestParam String startDate,
            @RequestParam String endDate
    ){
        BaseResponseDto<List<RoomRateAndAvailabilityDto>> result =
                inventoryService.getRoomRateAndRoomAvailability(startDate, endDate);
        if (result != null && !result.getData().isEmpty()){
            return ResponseEntity.ok(result);
        } else return new ResponseEntity<>(
                BaseResponseDto.<List<RoomRateAndAvailabilityDto>>builder()
                        .data(Collections.emptyList())
                        .flag(false)
                        .code(HttpStatus.NOT_FOUND.value())
                        .build(),HttpStatus.NOT_FOUND);
    }
}
