package com.l3azh.hcginterviewservicesbooking.hcginterviewservicesbooking.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Builder
@Data
@Getter
@Setter
public class RoomRateAndAvailabilityDto implements Serializable {
    Date date;
    List<RoomAvailabilityDto> roomAvailability;
    List<RoomRateDto> roomRate;
}
