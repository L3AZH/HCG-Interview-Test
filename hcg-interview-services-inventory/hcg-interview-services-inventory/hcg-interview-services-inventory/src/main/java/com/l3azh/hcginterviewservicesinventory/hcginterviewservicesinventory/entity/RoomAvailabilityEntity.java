package com.l3azh.hcginterviewservicesinventory.hcginterviewservicesinventory.entity;

import com.l3azh.hcginterviewservicesinventory.hcginterviewservicesinventory.entity.composite.RoomAvailabilityId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = EntityConstant.RoomAvailability.ROOM_AVAILABILITY_TABLE_NAME)
@IdClass(RoomAvailabilityId.class)
@Getter
@Setter
public class RoomAvailabilityEntity {

    @Id
    @ManyToOne
    @JoinColumn(name = EntityConstant.RoomAvailability.ROOM_TYPE_ID_COLUMN)
    private RoomTypeEntity roomTypeEntity;
    @Id
    @Column(name = EntityConstant.RoomAvailability.DATE_COLUMN)
    private Date date;
    @Column(name = EntityConstant.RoomAvailability.AVAILABLE_TO_SELL_COLUMN)
    private Integer availableToSell;
}
