package com.cyber.services;

import com.cyber.interfaces.ExtraSessions;
import org.springframework.stereotype.Component;

@Component
public class MockInterviewHours implements ExtraSessions {

    @Override
    public int getHours() {
        return 7;
    }
}
