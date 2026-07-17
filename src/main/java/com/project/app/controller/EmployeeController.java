package com.project.app.controller;

import com.project.app.configs.AppConstants;
import com.project.app.model.dto.EmployeeResponseDTO;
import com.project.app.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
//""
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<EmployeeResponseDTO> getEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping
    public ResponseEntity<EmployeeResponseDTO> getEmployeesWithParams(
            @RequestParam(name = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
            @RequestParam(name = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
            @RequestParam(name = "sortBy", defaultValue = AppConstants.SORT_EMPLOYES_USING_L, required = false) String sortBy,
            @RequestParam(name = "sortOrder", defaultValue = AppConstants.SORT_ORDER, required = false) String sortOrder
    ) {
        EmployeeResponseDTO responseDTO = employeeService
                .getEmployeesWithParams(pageNumber, pageSize, sortBy, sortOrder);
        return ResponseEntity.ok(responseDTO);
    }
}