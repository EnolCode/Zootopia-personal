package com.zootopia.demo.entity;
import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table (name="countries")
public class Country {

@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
@Column (name="id_country")
Long idCountry;

@Column ()
String country;

public Country(String country) {
    this.country = country;
}

public Country() {
}

}