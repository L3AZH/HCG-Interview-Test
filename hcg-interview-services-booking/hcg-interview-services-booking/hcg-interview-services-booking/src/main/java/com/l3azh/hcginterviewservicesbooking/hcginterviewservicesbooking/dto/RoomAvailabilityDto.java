package com.l3azh.hcginterviewservicesbooking.hcginterviewservicesbooking.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Builder
public class RoomAvailabilityDto {
    private Integer roomTypeId;
    private Integer availableToSell;
}
