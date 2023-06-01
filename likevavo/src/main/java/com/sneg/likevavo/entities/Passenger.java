package com.sneg.likevavo.entities;

import javax.persistence.*;

@Entity
@Table(name = "passengers")
public class Passenger {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "isAdult", nullable = false)
    private boolean isAdult;
    
    @Column(name = "isChild", nullable = false)
    private boolean isChild;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class", nullable = false)
    private FlightClass flightClass;
    
    // getters and setters
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public boolean isAdult() {
        return isAdult;
    }
    
    public void setAdult(boolean adult) {
        isAdult = adult;
    }
    
    public boolean isChild() {
        return isChild;
    }
    
    public void setChild(boolean child) {
        isChild = child;
    }
    
    public FlightClass getFlightClass() {
        return flightClass;
    }
    
    public void setFlightClass(FlightClass flightClass) {
        this.flightClass = flightClass;
    }
}