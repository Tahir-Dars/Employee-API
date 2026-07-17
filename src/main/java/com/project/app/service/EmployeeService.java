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
        Sort sortOrder=Sort.by(AppConstants.SORT_EMPLOYES_USING).ascending();
        int pageNumber=AppConstants.PAGE_NUMBER;
        int pageSize=AppConstants.PAGE_SIZE;
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sortOrder);
        Page<Employee> employeePage=employeeRepository.findAll(pageable);
        if (employeePage.isEmpty()){
            throw new APIException("No Employees on record !!");
        }
        List<EmployeeDTO> employeeDTOS = employeePage.stream()
                .map(category -> modelMapper.map(category, EmployeeDTO.class))
                .toList();
        EmployeeResponseDTO responseDTO=EmployeeResponseDTO.builder()
                .employeesList(employeeDTOS)
                .pageNumber(employeePage.getNumber())
                .pageSize(employeePage.getSize())
                .totalElements(employeePage.getTotalElements())
                .lastPage(employeePage.isLast())
                .totalPages(employeePage.getTotalPages())
                .build();
        return responseDTO;
    }
}