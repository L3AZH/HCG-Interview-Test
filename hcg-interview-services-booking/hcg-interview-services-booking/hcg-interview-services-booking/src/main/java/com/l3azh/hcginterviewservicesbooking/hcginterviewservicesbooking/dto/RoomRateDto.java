package com.l3azh.hcginterviewservicesbooking.hcginterviewservicesbooking.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Data
@Builder
public class RoomRateDto {
    private Integer roomTypeId;
    private Integer ratePlanId;
    private BigDecimal price;
}
