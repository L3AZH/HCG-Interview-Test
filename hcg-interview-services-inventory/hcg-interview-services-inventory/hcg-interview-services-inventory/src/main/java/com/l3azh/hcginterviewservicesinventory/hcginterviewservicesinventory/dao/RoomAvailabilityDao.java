package com.l3azh.hcginterviewservicesinventory.hcginterviewservicesinventory.dao;

import com.l3azh.hcginterviewservicesinventory.hcginterviewservicesinventory.entity.RoomAvailabilityEntity;
import com.l3azh.hcginterviewservicesinventory.hcginterviewservicesinventory.entity.RoomTypeEntity;
import com.l3azh.hcginterviewservicesinventory.hcginterviewservicesinventory.entity.composite.RoomAvailabilityId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RoomAvailabilityDao extends JpaRepository<RoomAvailabilityEntity, RoomAvailabilityId> {
    @Query(
            nativeQuery = true,
            value = "SELECT * " +
                    "FROM room_availability as ra " +
                    "WHERE ra.date >= :startDate AND ra.date <= :endDate"
    )
    List<RoomAvailabilityEntity> findFromDateToDate(
            @Param(value = "startDate") String startDate,
            @Param(value = "endDate") String endDate);
}
