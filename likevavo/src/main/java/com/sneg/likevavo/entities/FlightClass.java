package com.sneg.likevavo.entities;

import javax.persistence.*;

@Entity
@Table(name = "class")
public class FlightClass {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "economy", nullable = false)
    private boolean economy;
    
    @Column(name = "business", nullable = false)
    private boolean business;
    
    @Column(name = "firstclass", nullable = false)
    private boolean firstClass;
    
    public FlightClass() {
    }
    
    public FlightClass(boolean economy, boolean business, boolean firstClass) {
        this.economy = economy;
        this.business = business;
        this.firstClass = firstClass;
    }
    
    // getters and setters
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public boolean isEconomy() {
        return economy;
    }
    
    public void setEconomy(boolean economy) {
        this.economy = economy;
    }
    
    public boolean isBusiness() {
        return business;
    }
    
    public void setBusiness(boolean business) {
        this.business = business;
    }
    
    public boolean isFirstClass() {
        return firstClass;
    }
    
    public void setFirstClass(boolean firstClass) {
        this.firstClass = firstClass;
    }
}