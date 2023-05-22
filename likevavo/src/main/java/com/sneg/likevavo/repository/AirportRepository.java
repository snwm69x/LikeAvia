package com.sneg.likevavo.repository;



import org.springframework.data.jpa.repository.JpaRepository;


import com.sneg.likevavo.entities.Airport;

public interface AirportRepository extends JpaRepository<Airport, Long> {
    // @Query("SELECT DISTINCT a.city FROM Airport a")
    // List<String> findDistinctCities();
}
