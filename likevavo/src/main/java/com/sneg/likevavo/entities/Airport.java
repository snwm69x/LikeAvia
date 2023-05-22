package com.sneg.likevavo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "airports")
public class Airport {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "city_id", nullable = false)
    private City city;
    
    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;
    
    @Column(name = "code", nullable = false, length = 50)
    private String code;
    
    public Airport() {}
    
    public Airport(String name, City city, Country country, String code) {
        this.name = name;
        this.city = city;
        this.country = country;
        this.code = code;
    }
    
    // getters and setters
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public City getCity() {
        return city;
    }
    
    public void setCity(City city) {
        this.city = city;
    }
    
    public Country getCountry() {
        return country;
    }
    
    public void setCountry(Country country) {
        this.country = country;
    }
    
    public String getCode() {
        return code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
}
