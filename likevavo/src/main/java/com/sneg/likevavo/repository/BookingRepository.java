package com.sneg.likevavo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sneg.likevavo.entities.Booking;


public interface BookingRepository extends JpaRepository<Booking, Long> {
    
}
