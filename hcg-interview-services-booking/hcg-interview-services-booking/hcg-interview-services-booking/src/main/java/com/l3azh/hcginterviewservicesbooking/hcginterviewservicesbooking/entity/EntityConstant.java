package com.l3azh.hcginterviewservicesbooking.hcginterviewservicesbooking.entity;

public interface EntityConstant {


    interface Guest {
        String GUEST_TABLE_NAME = "guest";
        String EMAIL_COLUMN = "email";
        String PHONE_NUMBER_COLUMN = "phone_number";
    }

    interface Booking {
        String BOOKING_TABLE_NAME = "booking";
        String GUEST_EMAIL_COLUMN = "guest_email";
        String PRICE_COLUMN = "price";
        String ROOM_TYPE_ID_COLUMN = "room_type_id";
        String RATE_PLAN_ID_COLUMN = "rate_plan_id";
    }
}
