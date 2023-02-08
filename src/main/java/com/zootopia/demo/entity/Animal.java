package com.zootopia.demo.entity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity 
@Table(name = "animals")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;
    
    @Column(nullable = false, length = 50)
    private String type;

    @Column(nullable = false, length = 50)
    private String gender;

    @Column(nullable = false, length = 50)
    private String family;

    @Column(nullable = false, length = 50)
    private String country;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    // @Column(nullable = false, length = 50)
    // private String altura;
    
    // public String getAltura() {
    //     return altura;
    // }

    // public void setAltura(String altura) {
    //     this.altura = altura;
    // }

    // @ManyToOne(cascade = {CascadeType.ALL})
    // // @JsonIgnore
    // @JoinColumn(name= "id_type")
    // Type type;

    // @ManyToOne(cascade = {CascadeType.ALL})
    // // @JsonIgnore
    // @JoinColumn(name= "id_family")
    // Family family;

    // @ManyToOne(cascade = {CascadeType.ALL})
    // // @JsonIgnore
    // @JoinColumn(name= "id_genero")
    // Gender gender;

    // @ManyToOne(cascade = {CascadeType.ALL})
    // // @JsonIgnore
    // @JoinColumn(name= "id_pais")
    // Country country;

    // public Long getId() {
    //     return id;
    // }

    // public void setId(Long id) {
    //     this.id = id;
    // }

    // public String getName() {
    //     return name;
    // }

    // public void setName(String name) {
    //     this.name = name;
    // }

    // public Type getType() {
    //     return type;
    // }

    // public void setType(Type type) {
    //     this.type = type;
    // }

    // public Family getFamily() {
    //     return family;
    // }

    // public void setFamily(Family family) {
    //     this.family = family;
    // }

    // public Gender getGender() {
    //     return gender;
    // }

    // public void setGender(Gender gender) {
    //     this.gender = gender;
    // }

    // public Country getCountry() {
    //     return country;
    // }

    // public void setCountry(Country country) {
    //     this.country = country;
    // }
    
}
