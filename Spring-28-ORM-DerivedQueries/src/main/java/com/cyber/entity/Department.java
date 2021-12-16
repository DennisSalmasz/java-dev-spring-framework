package com.cyber.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "departments")
@ToString
public class Department {

    @Id
    private String department;
    private String division;
}
