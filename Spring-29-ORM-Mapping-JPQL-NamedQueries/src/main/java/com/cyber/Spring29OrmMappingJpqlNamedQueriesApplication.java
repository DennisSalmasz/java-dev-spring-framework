package com.cyber;

import com.cyber.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Spring29OrmMappingJpqlNamedQueriesApplication {

    @Autowired
    EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(Spring29OrmMappingJpqlNamedQueriesApplication.class, args);
    }

    @PostConstruct
    public void testEmployee(){

        System.out.println(employeeRepository.getEmployeeDetail());
        System.out.println(employeeRepository.getEmployeeSalary());
        System.out.println(employeeRepository.getEmployeeByEmail("btrow5@technorati.com").get());
        employeeRepository.updateEmployeeJPQL(1);
        System.out.println(employeeRepository.retrieveEmployeeSalaryGreaterThan(100000));
    }

}
