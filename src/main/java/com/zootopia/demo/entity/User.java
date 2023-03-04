package com.zootopia.demo.entity;
import java.util.Set;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;


    public User(String username, String password, Set<Role> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_authority",
        joinColumns = @JoinColumn(name="user_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn( name = "authority_id", referencedColumnName = "id"))
    private Set<Role> roles;

}
