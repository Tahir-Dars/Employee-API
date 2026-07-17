package com.project.app.controller;

import com.project.app.model.Employee;
import com.project.app.model.dto.EmployeeResponseDTO;
import com.project.app.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<EmployeeResponseDTO> getEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }
}