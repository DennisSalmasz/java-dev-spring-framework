package com.cyber.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.cyber") //if no package, will scan current package: com.cyber !!
public class CyberAppConfig {


}
