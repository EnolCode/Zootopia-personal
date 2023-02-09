package com.zootopia.demo.entity;

// import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
// import javax.persistence.JoinColumn;
import javax.persistence.Table;
// import com.zootopia.demo.entity.Animal;

@Entity
@Table (name="genders")
public class Gender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name ="id_gender")
    Long idgenero;

    @Column(name="gender")
    String gender;

    

    // @OneToMany(mappedBy ="genero")
    // private List<Animal> animals;


    public Long getIdgenero() {
        return idgenero;
    }

    public void setIdgenero(Long idgenero) {
        this.idgenero = idgenero;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    
   

    
}