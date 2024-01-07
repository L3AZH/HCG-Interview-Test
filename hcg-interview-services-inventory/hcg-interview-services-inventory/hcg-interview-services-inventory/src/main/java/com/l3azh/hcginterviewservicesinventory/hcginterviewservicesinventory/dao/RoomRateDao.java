package com.l3azh.hcginterviewservicesinventory.hcginterviewservicesinventory.dao;

import com.l3azh.hcginterviewservicesinventory.hcginterviewservicesinventory.entity.RoomRateEntity;
import com.l3azh.hcginterviewservicesinventory.hcginterviewservicesinventory.entity.composite.RoomRateId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRateDao extends JpaRepository<RoomRateEntity, RoomRateId> {
    @Query(
            nativeQuery = true,
            value = "SELECT * FROM room_rate as rr WHERE rr.date >= :startDate AND rr.date <= :endDate"
    )
    List<RoomRateEntity> findFromDateToDate(
            @Param(value = "startDate") String startDate,
            @Param(value = "endDate") String endDate);
}
