package com.sneg.likevavo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sneg.likevavo.entities.City;
import com.sneg.likevavo.repository.CityRepository;

@Service
public class OptionsService {
    
    private final CityRepository cityRepository;

    public OptionsService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }


    public List<City> getOptions() {
        return cityRepository.findAll();
    }
}
