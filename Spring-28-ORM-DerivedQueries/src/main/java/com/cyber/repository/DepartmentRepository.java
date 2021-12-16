package com.cyber.repository;

import com.cyber.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,String> {

    //display all departments in Furniture department
    List<Department> findByDepartment(String department);

    //display all departments in the health division
    List<Department> findByDivision(String division);
    List<Department> findByDivisionIs(String division);
    List<Department> findByDivisionEquals(String division);

    //display all departments with division name ending with ics
    List<Department> findByDivisionEndingWith(String pattern);

    //display top 3 departments with division name including 'Hea' without duplicates
    List<Department> findDistinctTop3ByDivisionContains(String pattern);
}
