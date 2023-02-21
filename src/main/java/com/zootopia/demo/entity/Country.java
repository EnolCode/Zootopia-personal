package com.zootopia.demo.entity;
import java.util.List;
import javax.persistence.*;


@Entity
@Table (name="countries")
public class Country {

@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
@Column (name="id_country")
Long idCountry;

@Column ()
String country;

public Long getIdCountry() {
    return idCountry;
}

public void setIdCountry(Long idCountry) {
    this.idCountry = idCountry;
}

public Country(String country) {
    this.country = country;
}

public String getCountry() {
    return country;
}

public void setCountry(String country) {
    this.country = country;
}


public Country(List<Animal> animals) {
    this.animals = animals;
    for(Animal animal : animals){
        animal.setCountry(this);
    }
}

public Country() {
}

@OneToMany(mappedBy = "country", cascade=CascadeType.ALL)
private List<Animal> animals;

}