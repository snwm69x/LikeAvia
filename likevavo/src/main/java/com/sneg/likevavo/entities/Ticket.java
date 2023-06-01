package com.sneg.likevavo.entities;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.persistence.*;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "route_id", nullable = false)
    private Route route;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "avia_company_id", nullable = false)
    private AviaCompany aviaCompany;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "departure_time", nullable = false)
    private Timestamp departureTime;

    @Column(name = "arrival_time", nullable = false)
    private Timestamp arrivalTime;

    @Column(name = "duration_flight", nullable = false)
    private String durationFlight;

    public Ticket() {}

    public Ticket(Route route, AviaCompany aviaCompany, BigDecimal price, Timestamp departureTime, Timestamp arrivalTime, String durationFlight) {
        this.route = route;
        this.aviaCompany = aviaCompany;
        this.price = price;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.durationFlight = durationFlight;
    }

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public AviaCompany getAviaCompany() {
        return aviaCompany;
    }

    public void setAviaCompany(AviaCompany aviaCompany) {
        this.aviaCompany = aviaCompany;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Timestamp getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Timestamp departureTime) {
        this.departureTime = departureTime;
    }

    public Timestamp getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Timestamp arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDurationFlight() {
        return durationFlight;
    }

    public void setDurationFlight(String durationFlight) {
        this.durationFlight = durationFlight;
    }
}