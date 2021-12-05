package com.cyber;

import com.cyber.calculator.Calculator;
import com.cyber.enums.City;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Spring18SpringBootIoCDiLabApplication {

    public static void main(String[] args) throws Exception {
        ApplicationContext container =
                SpringApplication.run(Spring18SpringBootIoCDiLabApplication.class, args);

        Calculator calculator = container.getBean("calculator",Calculator.class);

        System.out.println(calculator.getTotalCarpetCost(City.DULLES));
    }
}
