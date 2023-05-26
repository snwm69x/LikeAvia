package com.sneg.likevavo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sneg.likevavo.entities.Route;
import com.sneg.likevavo.entities.Ticket;


public interface RouteRepository extends JpaRepository<Route, Long> {
    @Query("SELECT t FROM Ticket t " +
            "JOIN t.route r " +
            "JOIN r.originAirport oa " +
            "JOIN r.destinationAirport da " +
            "JOIN r.originCity oc " +
            "JOIN r.destinationCity dc " +
            "WHERE oc.name = :originCityName " +
            "AND dc.name = :destinationCityName " +
            "AND r.date = :routeDate")
    List<Ticket> findByOriginCityNameAndDestinationCityNameAndRouteDate(String originCityName, String destinationCityName, LocalDate routeDate);

}
