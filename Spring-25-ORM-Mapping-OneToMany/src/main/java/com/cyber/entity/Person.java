package com.cyber.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    //since no cascade - first create person, then address!!
    //this drops the third table
    @OneToMany(mappedBy = "person") //no address_id in person table
    private List<Address> addresses;

    //case-1
    //cascade: when you create person, first create address !!
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name="person_id")
//    private List<Address> addresses;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
