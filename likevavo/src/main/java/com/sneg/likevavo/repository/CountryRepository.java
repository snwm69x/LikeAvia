package com.sneg.likevavo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sneg.likevavo.entities.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {
    
}
