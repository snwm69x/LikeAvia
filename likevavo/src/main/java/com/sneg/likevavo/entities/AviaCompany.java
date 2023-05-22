package com.sneg.likevavo.entities;
import jakarta.persistence.*;

@Entity
@Table(name = "avia_companies")
public class AviaCompany {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    
    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;
    
    public AviaCompany() {}
    
    public AviaCompany(String name, Country country) {
        this.name = name;
        this.country = country;
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
    
    public Country getCountry() {
        return country;
    }
    
    public void setCountry(Country country) {
        this.country = country;
    }
}