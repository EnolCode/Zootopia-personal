package com.zootopia.demo.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
// import javax.persistence.JoinColumn;
// import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import java.util.List;


@Entity 
@Table(name = "genders")
public class Gender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_gender")
    Long idGender;

    @Column(name = "gender")
    String gender;

    @OneToMany(mappedBy="gender")
    List<Animal> Animal;

    public Long getIdGender() {
        return idGender;
    }

    public void setIdGender(Long idGender) {
        this.idGender = idGender;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Animal> getAnimal() {
        return Animal;
    }

    public void setAnimal(List<Animal> animal) {
        Animal = animal;
    }
}
