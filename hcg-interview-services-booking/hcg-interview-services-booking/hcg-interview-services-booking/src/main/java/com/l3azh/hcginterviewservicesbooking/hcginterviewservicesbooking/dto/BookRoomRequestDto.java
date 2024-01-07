package com.l3azh.hcginterviewservicesbooking.hcginterviewservicesbooking.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@Builder
@Getter
@Setter
public class BookRoomRequestDto implements Serializable {
    private String startDate;
    private String endDate;
    private String guestEmail;
    private Integer roomTypeId;
    private Integer ratePlanId;

}
