package com.zootopia.demo.entity;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    
    public List<Animal> getAnimal() {
        return animal;
    }
    public void setAnimal(List<Animal> animal) {
        this.animal = animal;
    }
    @OneToMany(mappedBy = "family")
    private List<Animal> animal;

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
}
