package com.zootopia.demo.entity;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "name")
    String roleName;
    
    @ManyToMany(mappedBy = "roles")
    List <User> users;

    public Role(String roleName) {
        this.roleName = roleName;
    }

    // public String roleName;
}
