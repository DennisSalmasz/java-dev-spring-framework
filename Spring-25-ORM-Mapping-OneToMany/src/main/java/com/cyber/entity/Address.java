package com.cyber.entity;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String zipCode;

    @ManyToOne //FK is coming from ManyToOne
    private Person person;
}
