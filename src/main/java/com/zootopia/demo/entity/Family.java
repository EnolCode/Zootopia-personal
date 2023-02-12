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
@Table(name = "families")
public class Family {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_family")
    Long idFamily;

    @Column(name = "family")
    String family;


    public Long getIdFamily() {
        return idFamily;
    }

    public void setIdFamily(Long id) {
        this.idFamily = id;
    }


    public Family(Long id, String family, List<Animal> animals) {
        this.idFamily = id;
        this.family = family;
        this.animals = animals;
    }
    public Family() {
       
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String name) {
        this.family = name;
    }

    @OneToMany(mappedBy = "family")
    private List<Animal> animals;
}