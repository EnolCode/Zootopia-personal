package com.zootopia.demo.entity;

import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "families")
public class Family {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id_family")
    Long idFamily;

    @Column()
    String family;
}