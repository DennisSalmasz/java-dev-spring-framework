package com.cyber.services;

import com.cyber.interfaces.Course;

public class Java implements Course {

    @Override
    public void getTeachingHours() {
        System.out.println("Weekly Teaching Hours: 20");
    }
}
