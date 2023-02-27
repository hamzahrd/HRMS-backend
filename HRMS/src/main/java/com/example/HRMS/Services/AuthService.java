package com.example.HRMS.Services;

import com.example.HRMS.Entities.Employee;
import com.example.HRMS.Repository.EmployeeReposiory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private EmployeeReposiory employeeReposiory;
    public Employee authenticate(String email, String password) {
        Employee employee = employeeReposiory.findByEmailAndPassword(email, password);
        if (employee == null) {
            return null;
        }
        return employee;
    }
}
