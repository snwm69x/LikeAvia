package com.sneg.likevavo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sneg.likevavo.entities.FlightClass;

public interface FlightClassRepository extends JpaRepository<FlightClass, Long> {
    
}