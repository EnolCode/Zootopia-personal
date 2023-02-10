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
@Table (name="genders")
public class Gender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name ="id_gender")
    Long igGender;

    @Column(name="gender")
    String gender;


    public String getGender() {
        return gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public Gender() {
    }

    public void setIgGender(Long igGender) {
        this.igGender = igGender;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }


    @OneToMany(mappedBy ="gender")
    private List<Animal> animals;
    
}