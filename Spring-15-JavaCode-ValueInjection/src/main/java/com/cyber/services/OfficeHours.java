package com.cyber.services;

import com.cyber.interfaces.ExtraSessions;

public class OfficeHours implements ExtraSessions {

    @Override
    public int getHours() {
        return 7;
    }
}
