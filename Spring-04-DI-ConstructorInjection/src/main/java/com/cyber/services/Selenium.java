package com.cyber.services;

import com.cyber.interfaces.Course;

public class Selenium implements Course {

    @Override
    public void getTeachingHours() {
        System.out.println("Weekly Teaching Hours: 15");
    }
}
