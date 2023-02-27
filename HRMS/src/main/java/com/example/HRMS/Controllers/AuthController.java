package com.example.HRMS.Controllers;

import com.example.HRMS.Entities.Employee;
import com.example.HRMS.Repository.EmployeeReposiory;
import com.example.HRMS.Services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.*;


import java.util.List;

@RestController
public class AuthController {
    @Autowired
    private AuthService authService;
    @Autowired
    private EmployeeReposiory employeeReposiory;

    @PostMapping("/login")
    public ResponseEntity<Employee> login(@RequestParam String email, @RequestParam String password) {
        Employee employee = authService.authenticate(email, password);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employee);
    }
    @GetMapping("/employees")
    @PreAuthorize("hasAnyRole('ROLE_MANAGER','ROLE_ADMIN','ROLE_TEAMLEADER','ROLE_RH')")
    public List<Employee> getEmployees() {
        return employeeReposiory.findAll();
    }
}
