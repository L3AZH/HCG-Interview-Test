package com.l3azh.hcginterviewservicesinventory.hcginterviewservicesinventory.entity.composite;

import com.l3azh.hcginterviewservicesinventory.hcginterviewservicesinventory.entity.RoomTypeEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class RoomAvailabilityId implements Serializable {
    private RoomTypeEntity roomTypeEntity;
    private Date date;
    public RoomAvailabilityId(){}
    public RoomAvailabilityId(RoomTypeEntity roomTypeEntity, Date date){
        this.roomTypeEntity = roomTypeEntity;
        this.date = date;
    }
}
