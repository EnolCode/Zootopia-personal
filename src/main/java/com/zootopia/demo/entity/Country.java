package com.zootopia.demo.entity;

// import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
// import javax.persistence.JoinColumn;
// import javax.persistence.ManyToOne;
// import javax.persistence.OneToMany;
import javax.persistence.Table;

// import com.zootopia.demo.entity.Animal;
@Entity
@Table (name="countries")
public class Country {

@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
@Column (name="id_Country")
Long idCountry;

@Column (name="country")
String Country;

public Long getIdCountry() {
    return idCountry;
}

public void setIdCountry(Long idCountry) {
    this.idCountry = idCountry;
}

public String getCountry() {
    return Country;
}

public void setCountry(String country) {
    Country = country;
}







// @OneToMany(mappedBy = "pais")
// private List<Animal> animals;

}