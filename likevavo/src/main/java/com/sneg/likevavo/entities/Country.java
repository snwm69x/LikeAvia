package com.sneg.likevavo.entities;

import javax.persistence.*;

@Entity
@Table(name = "country")
public class Country {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    
    @Column(name = "translation_ru", nullable = false, length = 100)
    private String translationRu;
    
    @Column(name = "code", nullable = false, length = 100)
    private String code;
    
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
    
    public String getTranslationRu() {
        return translationRu;
    }
    
    public void setTranslationRu(String translationRu) {
        this.translationRu = translationRu;
    }
    
    public String getCode() {
        return code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
}