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
@Table(name = "families")
public class Family {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id_family")
    Long idFamily;

    @Column()
    String family;

    @OneToMany(mappedBy = "family",cascade=CascadeType.ALL)
    private List<Type> types;
}