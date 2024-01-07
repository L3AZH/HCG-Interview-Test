package com.l3azh.hcginterviewservicesinventory.hcginterviewservicesinventory.dao;

import com.l3azh.hcginterviewservicesinventory.hcginterviewservicesinventory.entity.RoomTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomTypeDao extends JpaRepository<RoomTypeEntity, Integer> {
}
