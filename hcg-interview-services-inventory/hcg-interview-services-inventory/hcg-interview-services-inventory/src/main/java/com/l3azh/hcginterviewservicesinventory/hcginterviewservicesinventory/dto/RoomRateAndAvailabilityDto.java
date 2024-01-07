package com.l3azh.hcginterviewservicesinventory.hcginterviewservicesinventory.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Data
@Builder
@Getter
@Setter
public class RoomRateAndAvailabilityDto {
    Date date;
    List<RoomAvailabilityDto> roomAvailability;
    List<RoomRateDto> roomRate;
}
