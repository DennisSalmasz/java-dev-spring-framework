package com.cyber.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    //one person has many address
    @OneToMany(mappedBy = "person") //this drops third table - no more bidirectional !!
    private List<Address> address;
}
