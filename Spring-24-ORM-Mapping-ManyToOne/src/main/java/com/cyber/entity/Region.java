package com.cyber.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "regions")
@NoArgsConstructor
@Getter
@Setter
public class Region extends BaseEntity{

    private String region;
    private String country;

    @OneToOne(mappedBy = "region") // region table will not have employee_id FK - emp parent, reg child !!
    private Employee employee;

    public Region(String region, String country) {
        this.region = region;
        this.country = country;
    }
}
