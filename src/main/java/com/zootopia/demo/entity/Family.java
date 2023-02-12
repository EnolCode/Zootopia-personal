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

    @Column(name = "name")
    String name;


    public Long getIdFamily() {
        return idFamily;
    }

    public void setIdFamily(Long id) {
        this.idFamily = id;
    }

    public Family(Long id, String name, List<Animal> animals) {
        this.idFamily = id;
        this.name = name;
        this.animals = animals;
    }
    public Family() {
       
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "family")
    private List<Animal> animals;
}