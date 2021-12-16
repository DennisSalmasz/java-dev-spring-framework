package com.cyber;

import com.cyber.entity.Region;
import com.cyber.repository.DepartmentRepository;
import com.cyber.repository.EmployeeRepository;
import com.cyber.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
public class Spring28OrmDerivedQueriesApplication {

    @Autowired
    RegionRepository regionRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(Spring28OrmDerivedQueriesApplication.class, args);
    }

    @PostConstruct
    public void testRegions(){
        System.out.println("-----------------Region start----------------");
        System.out.println("findByCountry: " + regionRepository.findByCountry("Canada"));
        System.out.println("findDistinctByCountry: " + regionRepository.findDistinctByCountry("Canada"));
        System.out.println("findByCountryContaining: " + regionRepository.findByCountryContaining("United"));
        System.out.println("findByCountryContainingOrderByCountry: " + regionRepository.findByCountryContainingOrderByCountry("Asia"));
        System.out.println("findTop2ByCountry: " + regionRepository.findTop2ByCountry("Canada"));
        System.out.println("-----------------Region end----------------");
    }

    @PostConstruct
    public void testDepartments(){
        System.out.println("-----------------Department start----------------");
        System.out.println("findByDepartment: " + departmentRepository.findByDepartment("Furniture"));
        System.out.println("findByDivision: " + departmentRepository.findByDivision("Health"));
        System.out.println("findByDivisionIs: " + departmentRepository.findByDivisionIs("Health"));
        System.out.println("findByDivisionEquals: " + departmentRepository.findByDivisionEquals("Health"));
        System.out.println("findByDivisionEndingWith: " + departmentRepository.findByDivisionEndingWith("ics"));
        System.out.println("findDistinctTop3ByDivisionContains: " + departmentRepository.findDistinctTop3ByDivisionContains("Hea"));
        System.out.println("-----------------Department end----------------");
    }

    @PostConstruct
    public void testEmployees(){
        System.out.println("-----------------Employee start----------------");
        System.out.println("findByEmail: " + employeeRepository.findByEmail(""));
        System.out.println("findByFirstNameAndLastNameOrEmail: " + employeeRepository.findByFirstNameAndLastNameOrEmail("","",""));
        System.out.println("findByFirstNameIsNot: " + employeeRepository.findByFirstNameIsNot(""));
        System.out.println("findByLastNameStartsWith: " + employeeRepository.findByLastNameStartsWith(""));
        System.out.println("findBySalaryGreaterThan: " + employeeRepository.findBySalaryGreaterThan(0));
        System.out.println("findBySalaryLessThan: " + employeeRepository.findBySalaryLessThan(0));
        //System.out.println("findByHireDateBetween: " + employeeRepository.findByHireDateBetween());
        System.out.println("findBySalaryGreaterThanEqualOrderBySalaryDesc: " + employeeRepository.findBySalaryGreaterThanEqualOrderBySalaryDesc(0));
        System.out.println("findDistinctTop3BySalaryLessThan: " + employeeRepository.findDistinctTop3BySalaryLessThan(0));
        System.out.println("findByEmailIsNull: " + employeeRepository.findByEmailIsNull());
        System.out.println("-----------------Employee end----------------");
    }

}
