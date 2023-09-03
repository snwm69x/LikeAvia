package com.sneg.likevavo.service_impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sneg.likevavo.entities.City;
import com.sneg.likevavo.repository.CityRepository;
import com.sneg.likevavo.service.OptionService;

@Service
public class OptionsServiceImpl implements OptionService {
    
    private final CityRepository cityRepository;

    public OptionsServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List<City> getOptions() {
        return cityRepository.findAll();
    }
}
