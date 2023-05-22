package com.sneg.likevavo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sneg.likevavo.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
    
}
