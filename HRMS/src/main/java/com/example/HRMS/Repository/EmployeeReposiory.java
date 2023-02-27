package com.example.HRMS.Repository;

import com.example.HRMS.Entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeReposiory extends JpaRepository<Employee, Long>{
    Employee findByEmail(String email);
    Employee findByEmailAndPassword(String email, String password);
}