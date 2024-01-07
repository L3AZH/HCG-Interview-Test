package com.l3azh.hcginterviewservicesinventory.hcginterviewservicesinventory.service;

import com.l3azh.hcginterviewservicesinventory.hcginterviewservicesinventory.dto.RoomRateAndAvailabilityDto;
import com.l3azh.hcginterviewservicesinventory.hcginterviewservicesinventory.dto.RoomTypeDto;
import com.l3azh.hcginterviewservicesinventory.hcginterviewservicesinventory.dto.base.BaseResponseDto;

import java.util.Date;
import java.util.List;

public interface InventoryService {
    BaseResponseDto<List<RoomRateAndAvailabilityDto>> getRoomRateAndRoomAvailability(String startDate, String endDate);
}
