package com.project.app.service;

import com.project.app.configs.AppConstants;
import com.project.app.exceptions.APIException;
import com.project.app.model.Employee;
import com.project.app.model.dto.EmployeeDTO;
import com.project.app.model.dto.EmployeeResponseDTO;
import com.project.app.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeResponseDTO getAllEmployees() {
        Sort sortOrder = Sort.by(AppConstants.SORT_EMPLOYES_USING_F).ascending();
        int pageNumber = 0;
        int pageSize = Integer.parseInt(AppConstants.PAGE_SIZE);
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sortOrder);
        Page<Employee> employeePage = employeeRepository.findAll(pageable);
        if (employeePage.isEmpty()) {
            throw new APIException("No Employees on record !!");
        }
        List<EmployeeDTO> employeeDTOS = employeePage.stream()
                .map(employee -> modelMapper.map(employee, EmployeeDTO.class))
                .toList();
        return EmployeeResponseDTO.builder()
                .employeesList(employeeDTOS)
                .pageNumber(employeePage.getNumber())
                .pageSize(employeePage.getSize())
                .totalElements(employeePage.getTotalElements())
                .lastPage(employeePage.isLast())
                .totalPages(employeePage.getTotalPages())
                .build();
    }

    public EmployeeResponseDTO getEmployeesWithParams(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder) {
        Sort sortBy_Order = sortOrder.equalsIgnoreCase("asc")
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sortBy_Order);
        Page<Employee> employeePage = employeeRepository.findAll(pageable);
        if (employeePage.isEmpty()) {
            throw new APIException("No Employee here");
        }
        List<EmployeeDTO> employeeDTOS = employeePage.stream()
                .map(employee -> modelMapper.map(employee, EmployeeDTO.class))
                .toList();
        return EmployeeResponseDTO.builder()
                .employeesList(employeeDTOS)
                .pageNumber(employeePage.getNumber())
                .pageSize(employeePage.getSize())
                .totalElements(employeePage.getTotalElements())
                .lastPage(employeePage.isLast())
                .totalPages(employeePage.getTotalPages())
                .build();
    }


    public EmployeeResponseDTO getEmployeesWithParamsAlot(Integer pageNumber, Integer pageSize, String sortBy1, String sortBy2) {

        Sort sort = Sort.by(
                Sort.Order.asc(sortBy1),
                Sort.Order.asc(sortBy2)
        );
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        Page<Employee> employeePage = employeeRepository.findAll(pageable);
        if (employeePage.isEmpty()) {
            throw new APIException("No Employee here");
        }
        List<EmployeeDTO> employeeDTOS = employeePage.stream()
                .map(employee -> modelMapper.map(employee, EmployeeDTO.class))
                .toList();
        return EmployeeResponseDTO.builder()
                .employeesList(employeeDTOS)
                .pageNumber(employeePage.getNumber())
                .pageSize(employeePage.getSize())
                .totalElements(employeePage.getTotalElements())
                .lastPage(employeePage.isLast())
                .totalPages(employeePage.getTotalPages())
                .build();
    }

}