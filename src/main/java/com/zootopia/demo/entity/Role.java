package com.zootopia.demo.entity;
import java.util.List;

import javax.persistence.*;
import com.zootopia.demo.utils.RoleName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "authorities")
public class Role {

    public Role(RoleName roleName){
        this.name = roleName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoleName name;
    
    @ManyToMany(mappedBy = "roles")
    List <User> users;

    // public String roleName;
}
