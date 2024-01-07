package com.l3azh.hcginterviewservicesinventory.hcginterviewservicesinventory.entity;

public interface EntityConstant {

    interface Hotel {
        String HOTEL_TABLE_NAME = "hotel";
        String NAME_COLUMN = "name";
    }

    interface RoomType {
        String ROOM_TYPE_TABLE_NAME = "room_type";
        String NAME_COLUMN = "name";
    }

    interface RatePlan {
        String RATE_PLAN_TABLE_NAME = "rate_plan";
        String NAME_COLUMN = "name";
    }

    interface Period {
        String PERIOD_TABLE_NAME = "period";
        String START_DATE_COLUMN = "start_date";
        String END_DATE_COLUMN = "end_date";
    }
    interface RoomRate {
        String ROOM_RATE_TABLE_NAME = "room_rate";
        String ROOM_TYPE_ID_COLUMN = "room_type_id";
        String PRICE_COLUMN = "price";
        String DATE_COLUMN ="date";
        String DEFAULT_RATE_PLAN_COLUMN = "default_rate_plan";
    }
    interface RoomAvailability {
        String ROOM_AVAILABILITY_TABLE_NAME = "room_availability";
        String ROOM_TYPE_ID_COLUMN = "room_type_id";
        String AVAILABLE_TO_SELL_COLUMN = "available_to_sell";
        String DATE_COLUMN ="date";
    }

    interface RelationshipPeriodAndRatePlan{
        String TABLE_NAME = "period_rel_rate_plan";
        String PERIOD_ID_COLUMN = "period_id";
        String RATE_PLAN_ID_COLUMN = "rate_plan_id";
    }

    interface RelationshipRoomTypeAndRatePlan{
        String TABLE_NAME = "room_type_rel_rate_plan";
        String ROOM_TYPE_ID_COLUMN = "room_type_id";
        String RATE_PLAN_ID_COLUMN = "rate_plan_id";
    }

    interface RelationshipHotelAndRoomType{
        String TABLE_NAME = "hotel_rel_room_type";
        String HOTEL_ID_COLUMN = "hotel_id";
        String ROOM_TYPE_ID_COLUMN = "room_type_id";
    }

    interface RelationshipHotelAndRatePlan{
        String TABLE_NAME = "hotel_rel_rate_plan";
        String HOTEL_ID_COLUMN = "hotel_id";
        String RATE_PLAN_ID_COLUMN = "rate_plan_id";
    }
}
