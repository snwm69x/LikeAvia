package com.sneg.likevavo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sneg.likevavo.entities.Ticket;
import com.sneg.likevavo.repository.RouteRepository;

@Service
public class SearchService {
    private final RouteRepository routeRepository;

    public SearchService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public List<Ticket> search(String from, String to, LocalDate date) {
        return routeRepository.findByOriginCityNameAndDestinationCityNameAndRouteDate(from, to, date);
    }
}