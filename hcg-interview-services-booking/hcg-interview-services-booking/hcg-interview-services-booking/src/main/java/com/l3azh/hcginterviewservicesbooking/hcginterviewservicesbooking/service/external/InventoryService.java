package com.l3azh.hcginterviewservicesbooking.hcginterviewservicesbooking.service.external;

import com.l3azh.hcginterviewservicesbooking.hcginterviewservicesbooking.dto.RoomRateAndAvailabilityDto;
import com.l3azh.hcginterviewservicesbooking.hcginterviewservicesbooking.dto.base.BaseResponseDto;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryService {
    String BASE_URL = "http://localhost:9090/v1";
    interface GetRoomRateAndAvailability {
        HttpMethod METHOD = HttpMethod.GET;
        String URL = "/getRoomRateAndAvailability";
        BaseResponseDto<List<RoomRateAndAvailabilityDto>> getRoomRateAndRoomAvailability(String startDate, String endDate);
    }

}
