package com.cyber.repository;

import com.cyber.entity.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    //display all employees withe email address
    List<Employee> findByEmail(String email);

    //display all employees with first name '' and last name '', also show all employees with email ''
    List<Employee> findByFirstNameAndLastNameOrEmail(String firstName,String lastName,String email);

    //display all employees that first name is not ''
    List<Employee> findByFirstNameIsNot(String firstName);

    //display all employees where last name starts with ''
    List<Employee> findByLastNameStartsWith(String pattern);

    //display all employees with salary higher than ''
    List<Employee> findBySalaryGreaterThan(Integer salary);

    //display all employees with salary less than ''
    List<Employee> findBySalaryLessThan(Integer salary);

    //display all employees that has been hired between '' and ''
    List<Employee> findByHireDateBetween(LocalDate startDate,LocalDate endDate);

    //display all employees greater and equal to '' in order
    List<Employee> findBySalaryGreaterThanEqualOrderBySalaryDesc(Integer salary);

    //display top 3 unique employees that is making less than ''
    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);

    //display all employees that do not have email address
    List<Employee> findByEmailIsNull();

}
