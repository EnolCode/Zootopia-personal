package com.zootopia.demo.entity;

import javax.persistence.*;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table (name="types")
public class Type {

@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
@Column (name="id_type")
Long idType;

@Column()
String type;

public Type(String type) {
    this.type = type;
}
}