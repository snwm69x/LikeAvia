package com.sneg.likevavo.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "routes")
public class Route {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "origin_airport_id", nullable = false)
    private Airport originAirport;
    
    @ManyToOne
    @JoinColumn(name = "destination_airport_id", nullable = false)
    private Airport destinationAirport;
    
    @Column(name = "date", nullable = false)
    private LocalDate date;
    
    @ManyToOne
    @JoinColumn(name = "origin_city_id", nullable = false)
    private City originCity;
    
    @ManyToOne
    @JoinColumn(name = "destination_city_id", nullable = false)
    private City destinationCity;
    
    public Route() {}
    
    public Route(Airport originAirport, Airport destinationAirport, LocalDate date, City originCity, City destinationCity) {
        this.originAirport = originAirport;
        this.destinationAirport = destinationAirport;
        this.date = date;
        this.originCity = originCity;
        this.destinationCity = destinationCity;
    }
    
    // getters and setters
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Airport getOriginAirport() {
        return originAirport;
    }
    
    public void setOriginAirport(Airport originAirport) {
        this.originAirport = originAirport;
    }
    
    public Airport getDestinationAirport() {
        return destinationAirport;
    }
    
    public void setDestinationAirport(Airport destinationAirport) {
        this.destinationAirport = destinationAirport;
    }
    
    public String getDate() {
        return date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
    
    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    public City getOriginCity() {
        return originCity;
    }
    
    public void setOriginCity(City originCity) {
        this.originCity = originCity;
    }
    
    public City getDestinationCity() {
        return destinationCity;
    }
    
    public void setDestinationCity(City destinationCity) {
        this.destinationCity = destinationCity;
    }
}