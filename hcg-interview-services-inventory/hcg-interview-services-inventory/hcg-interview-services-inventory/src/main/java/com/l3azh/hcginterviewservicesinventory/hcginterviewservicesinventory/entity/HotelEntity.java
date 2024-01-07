package com.l3azh.hcginterviewservicesinventory.hcginterviewservicesinventory.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = EntityConstant.Hotel.HOTEL_TABLE_NAME)
public class HotelEntity {
    @Id
    private Integer id;
    @Column(name = EntityConstant.Hotel.NAME_COLUMN)
    private String name;

    @ManyToMany
    @JoinTable(
            name = EntityConstant.RelationshipHotelAndRoomType.TABLE_NAME,
            joinColumns = @JoinColumn(name = EntityConstant.RelationshipHotelAndRoomType.HOTEL_ID_COLUMN),
            inverseJoinColumns = @JoinColumn(name = EntityConstant.RelationshipHotelAndRoomType.ROOM_TYPE_ID_COLUMN))
    private List<RoomTypeEntity> roomTypeEntityList;
    @ManyToMany
    @JoinTable(
            name = EntityConstant.RelationshipHotelAndRatePlan.TABLE_NAME,
            joinColumns = @JoinColumn(name = EntityConstant.RelationshipHotelAndRatePlan.HOTEL_ID_COLUMN),
            inverseJoinColumns = @JoinColumn(name = EntityConstant.RelationshipHotelAndRatePlan.RATE_PLAN_ID_COLUMN))
    private List<RatePlanEntity> ratePlanEntityList;
}
