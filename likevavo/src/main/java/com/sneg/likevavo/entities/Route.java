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
    
    public Route() {}
    
    public Route(Airport originAirport, Airport destinationAirport, LocalDate date) {
        this.originAirport = originAirport;
        this.destinationAirport = destinationAirport;
        this.date = date;
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
}