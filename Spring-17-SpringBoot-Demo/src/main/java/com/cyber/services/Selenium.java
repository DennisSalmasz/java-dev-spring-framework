package com.cyber.services;

import com.cyber.interfaces.Course;
import org.springframework.stereotype.Component;

@Component
public class Selenium implements Course {

    @Override
    public int getTeachingHours() {
        return 10;
    }
}
