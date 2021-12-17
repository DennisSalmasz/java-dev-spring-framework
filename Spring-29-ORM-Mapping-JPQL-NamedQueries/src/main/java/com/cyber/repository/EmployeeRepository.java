package com.cyber.repository;

import com.cyber.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    @Query("SELECT e FROM Employee e WHERE e.email = 'dtrail8@tamu.edu'")
    Employee getEmployeeDetail();

    @Query("SELECT e.salary FROM Employee e WHERE e.email = 'dtrail8@tamu.edu'")
    Integer getEmployeeSalary();

    //single bind parameter
    @Query("SELECT e FROM Employee e WHERE e.email = ?1")
    Optional<Employee> getEmployeeByEmail(String email);

    //multiple bind parameter
    @Query("SELECT e FROM Employee e WHERE e.email = ?1 AND e.salary = ?2")
    Optional<Employee> getEmployeeByEmailAndSalary(String email,Integer salary);

    //single named parameter
    @Query("SELECT e FROM Employee e WHERE e.salary =: salary")
    Employee getEmployeeBySalary(@Param("salary") Integer salary);

    //multiple named parameter
    @Query("SELECT e FROM Employee e WHERE e.firstName =: name OR e.salary =: salary")
    List<Employee> getEmployeeByFirstNameOrSalary(@Param("name") String name,@Param("salary") Integer salary);

    //not equal
    @Query("SELECT e FROM Employee e WHERE e.salary <> ?1 ")
    List<Employee> getEmployeeBySalaryNotEqual(Integer salary);

    //like / contains / startsWith / endsWith
    @Query("SELECT e FROM Employee e WHERE e.firstName LIKE ?1")
    List<Employee> getEmployeeByFirstNameLike(String pattern);

    //less than
    @Query("SELECT e FROM Employee e WHERE e.salary < ?1")
    List<Employee> getEmployeeBySalaryLessThan(Integer salary);

    //greater than
    @Query("SELECT e FROM Employee e WHERE e.salary > ?1")
    List<Employee> getEmployeeBySalaryGreaterThan(Integer salary);

    //between
    @Query("SELECT e FROM Employee e WHERE e.salary BETWEEN ?1 AND ?2")
    List<Employee> getEmployeeBySalaryBetween(Integer salary1,Integer salary2);

    //before
    @Query("SELECT e FROM Employee e WHERE e.hireDate > ?1")
    List<Employee> getEmployeeByHireDateBefore(LocalDate date);

    //null
    @Query("SELECT e FROM Employee e WHERE e.email IS NULL")
    List<Employee> getEmployeeByEmailIsNull();

    //not null
    @Query("SELECT e FROM Employee e WHERE e.email IS NOT NULL")
    List<Employee> getEmployeeByEmailIsNotNull();

    //sort salary in asc order
    @Query("SELECT e FROM Employee e ORDER BY e.salary")
    List<Employee> getEmployeeBySalaryOrderByAsc();

    //sort salary in desc order
    @Query("SELECT e FROM Employee e ORDER BY e.salary DESC")
    List<Employee> getEmployeeBySalaryOrderByDesc();

    //Native Query - will work o DB!!
    @Query(value = "select * from employees where salary = ?1", nativeQuery = true)
    List<Employee> readEmployeeBySalary(int salary);

    //update
    @Modifying
    @Transactional
    @Query("UPDATE Employee e set e.email = 'admin@email.com' where e.id =:id")
    void updateEmployeeJPQL(@Param("id") Integer id);

    //update - native query
    @Modifying
    @Transactional
    @Query(value = "UPDATE employees SET email='' WHERE id =:id",nativeQuery = true)
    void updateEmployeeNativeQuery(@Param("id") Integer id);

    //named query
    List<Employee> retrieveEmployeeSalaryGreaterThan(Integer salary);





}
