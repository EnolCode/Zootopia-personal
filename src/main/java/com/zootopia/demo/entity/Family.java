package com.zootopia.demo.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity 
@Table(name = "familys")
public class Family {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_family")
    Long idFamily;


    @Column(name = "family")
    String family;


    @ManyToOne
    @JoinColumn(name="id_animal")
    Animal animal;

    public Long getIdFamily() {
        return idFamily;
    }
    public void setIdFamily(Long idFamily) {
        this.idFamily = idFamily;
    }
    public String getFamily() {
        return family;
    }
    public void setFamily(String family) {
        this.family = family;
    }
    public Animal getAnimal() {
        return animal;
    }
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
   
   
   
}
