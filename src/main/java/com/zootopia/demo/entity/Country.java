package com.zootopia.demo.entity;
import java.util.List;
import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table (name="countries")
public class Country {

@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
@Column (name="id_country")
Long idCountry;

@Column ()
String country;

public Country(List<Animal> animals) {
    this.animals = animals;
    for(Animal animal : animals){
        animal.setCountry(this);
    }
}

public Country(String country) {
    this.country = country;
}

@OneToMany(mappedBy = "country", cascade=CascadeType.ALL)
private List<Animal> animals;

}