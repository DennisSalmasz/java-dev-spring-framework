package com.cyber.services;

import com.cyber.interfaces.Course;
import com.cyber.interfaces.ExtraSessions;
import lombok.Data;

@Data
public class Java implements Course {

    ExtraSessions extraSessions;
    /*
    public OfficeHours getOfficeHours() {
        return officeHours;
    }

    public void setOfficeHours(OfficeHours officeHours) {
        this.officeHours = officeHours;
    }
    */

    @Override
    public void getTeachingHours() {
        System.out.println("Weekly Teaching Hours: " + (20 + extraSessions.getHours()));
    }
}
