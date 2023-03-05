package com.zootopia.demo.entity;
import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table (name="types")
public class Type {

@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
@Column (name="id_type")
Long idType;

public Type(String type) {
    this.type = type;
}

@Column()
String type;

@OneToMany(mappedBy ="type")
    private List<Animal> animals;

@ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
@JoinColumn(name = "family_id", nullable = true)
Family family;


}