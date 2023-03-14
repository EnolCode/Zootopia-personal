package com.zootopia.demo.entity;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iduser")
    private Long id;

    private String name;
    private String email;
    private String password;
}
