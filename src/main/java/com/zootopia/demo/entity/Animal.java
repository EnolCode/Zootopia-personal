package com.zootopia.demo.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 
@Table(name = "animals")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;
    
    @Column(nullable = true, length = 50)
    private Date date;

    @OneToMany(mappedBy="family")
    List<Family> familyAnimal;

    @OneToMany(mappedBy="type")
    List<Type> typeAnimal;

    public void setId(Long id) {
        this.id = id;
    }


    public Date getDate() {
        return date;
    }


    public void setDate(Date date) {
        this.date = date;
    }


    public List<Family> getFamilyAnimal() {
        return familyAnimal;
    }


    public void setFamilyAnimal(List<Family> familyAnimal) {
        this.familyAnimal = familyAnimal;
    }


    public List<Type> getTypeAnimal() {
        return typeAnimal;
    }


    public void setTypeAnimal(List<Type> typeAnimal) {
        this.typeAnimal = typeAnimal;
    }


    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
