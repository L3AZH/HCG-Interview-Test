package com.l3azh.hcginterviewservicesinventory.hcginterviewservicesinventory.entity.composite;

import com.l3azh.hcginterviewservicesinventory.hcginterviewservicesinventory.entity.RoomTypeEntity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class RoomRateId implements Serializable {
    private RoomTypeEntity roomTypeEntity;
    private Date date;
    public RoomRateId(){}
    public RoomRateId(RoomTypeEntity roomTypeEntity, Date date){
        this.roomTypeEntity = roomTypeEntity;
        this.date = date;
    }

}
