package com.zootopia.demo.entity;

import java.util.List;

import javax.persistence.*;


@Entity
@Table (name="types")
public class Type {

@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
@Column (name="id_type")
Long idType;

@Column()
String type;

public Long getIdType() {
    return idType;
}


public void setIdType(Long idType) {
    this.idType = idType;
}


public String getType() {
    return type;
}


public void setType(String type) {
    this.type = type;
}


public Type(String type) {
    this.type = type;
}


public Type() {
}

@OneToMany(mappedBy ="type", cascade=CascadeType.ALL)
    private List<Animal> animals;
}