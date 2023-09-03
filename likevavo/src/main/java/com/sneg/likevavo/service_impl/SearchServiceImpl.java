package com.sneg.likevavo.service_impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sneg.likevavo.entities.Ticket;
import com.sneg.likevavo.repository.RouteRepository;
import com.sneg.likevavo.service.SearchService;

@Service
public class SearchServiceImpl implements SearchService {
    private final RouteRepository routeRepository;

    public SearchServiceImpl(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @Override
    public List<Ticket> search(String from, String to, LocalDate date) {
        return routeRepository.findByOriginCityNameAndDestinationCityNameAndRouteDate(from, to, date);
    }
}