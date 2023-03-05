package com.zootopia.demo.entity;
import java.sql.Date;
import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "animals")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 50, nullable = true)
    private Date date;

    @Column(length = 50, nullable = true)
    private String gender;

    @ManyToOne(fetch = FetchType.EAGER)    
    @JoinColumn(name= "country_id" , nullable = true, referencedColumnName = "id_country")
    Country country;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "type_id", nullable = true)
    Type type;
}
