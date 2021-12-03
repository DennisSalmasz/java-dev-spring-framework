package com.cyber.configs;

import com.cyber.interfaces.ExtraSessions;
import com.cyber.services.Java;
import com.cyber.services.OfficeHours;
import com.cyber.services.Selenium;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.cyber")
public class CyberAppConfig {

    //this structure is good if you work with third party tool !!

    @Bean
    public Java java(){
        return new Java(extraSessions());
    }

    @Bean
    public Selenium selenium(){
        return new Selenium();
    }

    /*
    @Bean
    public OfficeHours officeHours(){
        return new OfficeHours();
    }
    */

    //@Bean
    public ExtraSessions extraSessions(){
        return new OfficeHours();
    }
}
