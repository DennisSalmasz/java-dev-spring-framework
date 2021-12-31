package com.cyber.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "class")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"},ignoreUnknown = true)
public class Class extends BaseEntity{

    private String name;
    private String year;

    @ManyToOne(fetch = FetchType.LAZY) // many class can be assigned to one course
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne(fetch = FetchType.LAZY) // many class can be assigned to one teacher
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
}
