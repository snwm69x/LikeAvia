package com.sneg.likevavo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sneg.likevavo.entities.City;

public interface CityRepository extends JpaRepository<City, Long> {
}
