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
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<EmployeeResponseDTO> getEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/senetence")
    public ResponseEntity<EmployeeResponseDTO> getEmployeesWithParams(
            @RequestParam(name = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
            @RequestParam(name = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
            @RequestParam(name = "sortBy1", defaultValue = AppConstants.SORT_EMPLOYES_USING_L, required = false) String sortBy1,
            @RequestParam(name = "sortOrder", defaultValue = AppConstants.SORT_ORDER, required = false) String sortOrder1,
            @RequestParam(name = "sortBy2", defaultValue = AppConstants.SORT_EMPLOYES_USING_Salary, required = false) String sortBy2,
            @RequestParam(name = "dept", required = false) String dept
    ) {
        if (sortBy2 == null || sortBy2.isEmpty()) {
            EmployeeResponseDTO responseDTO = employeeService
                    .getEmployeesWithParams(pageNumber, pageSize, sortBy1, sortOrder1);
            return ResponseEntity.ok(responseDTO);

        }
        EmployeeResponseDTO responseDTO = employeeService
                .getEmployeesWithParamsAlot(pageNumber, pageSize, sortBy1, sortBy2);

        return ResponseEntity.ok(responseDTO);
    }
}