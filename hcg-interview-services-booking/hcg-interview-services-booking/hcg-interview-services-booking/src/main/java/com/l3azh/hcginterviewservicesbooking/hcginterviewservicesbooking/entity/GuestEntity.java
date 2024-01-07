package com.l3azh.hcginterviewservicesbooking.hcginterviewservicesbooking.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = EntityConstant.Guest.GUEST_TABLE_NAME)
public class GuestEntity {
    @Id
    @Column(name = EntityConstant.Guest.EMAIL_COLUMN)
    private String name;
    @Column(name = EntityConstant.Guest.PHONE_NUMBER_COLUMN)
    private String phoneNumber;
}
