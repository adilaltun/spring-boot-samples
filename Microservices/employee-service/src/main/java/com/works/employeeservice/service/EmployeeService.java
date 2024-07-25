package com.works.employeeservice.service;

import com.works.employeeservice.dto.APIResponseDto;
import com.works.employeeservice.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto save(EmployeeDto employeeDto);

    List<EmployeeDto> getAllEmployee();

    APIResponseDto getEmployeeById(Long id);

}
