package com.cyber.services;

import com.cyber.interfaces.Course;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Java implements Course {

    //field injection
    @Autowired
    private OfficeHours officeHours;

    /*
    //constructor injection
    @Autowired
    public Java(OfficeHours officeHours) {
        this.officeHours = officeHours;
    }
    */

    /*
    //setter injection
    @Autowired
    public void setOfficeHours(OfficeHours officeHours) {
        this.officeHours = officeHours;
    }
    */

    @Override
    public void getTeachingHours() {
        System.out.println("Weekly Teaching Hours: " + (30 + officeHours.getHours()));
    }
}
