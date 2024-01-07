package com.l3azh.hcginterviewservicesinventory.hcginterviewservicesinventory.entity;

import com.l3azh.hcginterviewservicesinventory.hcginterviewservicesinventory.entity.composite.RoomRateId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = EntityConstant.RoomRate.ROOM_RATE_TABLE_NAME)
@IdClass(RoomRateId.class)
@Getter
@Setter
public class RoomRateEntity {
    @Id
    @ManyToOne
    @JoinColumn(name = EntityConstant.RoomRate.ROOM_TYPE_ID_COLUMN)
    private RoomTypeEntity roomTypeEntity;
    @Id
    @Column(name = EntityConstant.RoomRate.DATE_COLUMN)
    private Date date;
    @Column(name = EntityConstant.RoomRate.PRICE_COLUMN)
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = EntityConstant.RoomRate.DEFAULT_RATE_PLAN_COLUMN)
    private RatePlanEntity ratePlanEntity;
}
