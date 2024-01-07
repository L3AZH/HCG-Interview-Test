package com.l3azh.hcginterviewservicesinventory.hcginterviewservicesinventory.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = EntityConstant.RoomType.ROOM_TYPE_TABLE_NAME)
@Getter
@Setter
public class RoomTypeEntity {
    @Id
    private Integer id;
    @Column(name = EntityConstant.RoomType.NAME_COLUMN)
    private String name;
    @OneToMany(mappedBy = "roomTypeEntity")
    private List<RoomRateEntity> roomRateEntityList;
    @OneToMany(mappedBy = "roomTypeEntity")
    private List<RoomAvailabilityEntity> roomAvailabilityEntityList;
    @ManyToMany
    @JoinTable(
            name = EntityConstant.RelationshipRoomTypeAndRatePlan.TABLE_NAME,
            joinColumns = @JoinColumn(name = EntityConstant.RelationshipRoomTypeAndRatePlan.ROOM_TYPE_ID_COLUMN),
            inverseJoinColumns = @JoinColumn(name = EntityConstant.RelationshipRoomTypeAndRatePlan.RATE_PLAN_ID_COLUMN))
    private List<RatePlanEntity> ratePlanEntityList;
}
