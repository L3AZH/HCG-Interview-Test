package com.l3azh.hcginterviewservicesbooking.hcginterviewservicesbooking.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = EntityConstant.Booking.BOOKING_TABLE_NAME)
@Builder
@Getter
@Setter
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = EntityConstant.Booking.GUEST_EMAIL_COLUMN)
    private String guestEmail;
    @Column(name = EntityConstant.Booking.PRICE_COLUMN)
    private BigDecimal price;
    @Column(name = EntityConstant.Booking.ROOM_TYPE_ID_COLUMN)
    private Integer roomTypeId;
    @Column(name = EntityConstant.Booking.RATE_PLAN_ID_COLUMN)
    private Integer ratePlanId;
}
