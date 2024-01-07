package com.l3azh.hcginterviewservicesbooking.hcginterviewservicesbooking.dao;

import com.l3azh.hcginterviewservicesbooking.hcginterviewservicesbooking.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingDao extends JpaRepository<BookingEntity,Integer> {
}
