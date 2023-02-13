package com.zootopia.demo.entity;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table (name="countries")
public class Country {

@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
@Column (name="id_country")
Long idCountry;

@Column (name="country")
String country;

public Long getIdCountry() {
    return idCountry;
}

public void setIdCountry(Long idCountry) {
    this.idCountry = idCountry;
}

public String getCountry() {
    return country;
}

public Country() {
    
}
public void setCountry(String country) {
    this.country = country;
}

public Country(List<Animal> animals) {
    this.animals = animals;
}

@OneToMany(mappedBy = "country", cascade=CascadeType.ALL)
private List<Animal> animals;

}