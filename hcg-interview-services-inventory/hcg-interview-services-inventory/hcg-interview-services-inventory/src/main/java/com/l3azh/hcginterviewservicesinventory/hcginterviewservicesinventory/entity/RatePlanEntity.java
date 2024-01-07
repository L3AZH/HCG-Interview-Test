package com.l3azh.hcginterviewservicesinventory.hcginterviewservicesinventory.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = EntityConstant.RatePlan.RATE_PLAN_TABLE_NAME)
@Getter
@Setter
public class RatePlanEntity {
    @Id
    private Integer id;
    @Column(name = EntityConstant.RatePlan.NAME_COLUMN)
    private String name;

    @OneToMany(mappedBy = "ratePlanEntity")
    private List<RoomRateEntity> roomRateEntityList;
    @ManyToMany
    @JoinTable(
            name = EntityConstant.RelationshipPeriodAndRatePlan.TABLE_NAME,
            joinColumns = @JoinColumn(name = EntityConstant.RelationshipPeriodAndRatePlan.RATE_PLAN_ID_COLUMN),
            inverseJoinColumns = @JoinColumn(name = EntityConstant.RelationshipPeriodAndRatePlan.PERIOD_ID_COLUMN))
    private List<PeriodEntity> periodEntityList;
    @ManyToMany
    @JoinTable(
            name = EntityConstant.RelationshipRoomTypeAndRatePlan.TABLE_NAME,
            joinColumns = @JoinColumn(name = EntityConstant.RelationshipRoomTypeAndRatePlan.RATE_PLAN_ID_COLUMN),
            inverseJoinColumns = @JoinColumn(name = EntityConstant.RelationshipRoomTypeAndRatePlan.ROOM_TYPE_ID_COLUMN))
    private List<RoomTypeEntity> roomTypeEntityList;
}
