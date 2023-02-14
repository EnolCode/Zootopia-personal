package com.zootopia.demo.entity;
import java.util.List;
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

public void setCountry(String country) {
    this.country = country;
}

@OneToMany(mappedBy = "country")
private List<Animal> animals;

}