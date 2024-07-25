package com.works.employeeservice.service.impl;

import com.works.employeeservice.dto.APIResponseDto;
import com.works.employeeservice.dto.DepartmentDto;
import com.works.employeeservice.dto.EmployeeDto;
import com.works.employeeservice.entity.Employee;
import com.works.employeeservice.exception.EmployeeNotFoundException;
import com.works.employeeservice.repository.EmployeeRepository;
import com.works.employeeservice.service.APIClient;
import com.works.employeeservice.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;
    //private final RestTemplate restTemplate;
    //private final WebClient webClient;
    private final APIClient apiClient;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper, APIClient apiClient) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
        this.apiClient = apiClient;
        //this.webClient = webClient;
        //this.restTemplate = restTemplate;
    }

    @Override
    public EmployeeDto save(EmployeeDto employeeDto) {
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        Employee save = employeeRepository.save(employee);
        EmployeeDto map = modelMapper.map(save, EmployeeDto.class);
        return map;
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> all = employeeRepository.findAll();
        List<EmployeeDto> getAllEmployee = all.stream().map(employee -> modelMapper.map(employee, EmployeeDto.class)).collect(Collectors.toList());
        return getAllEmployee;
    }

    @Override
    public APIResponseDto getEmployeeById(Long employeeId) {
        try {
            Employee employee1 = employeeRepository.findById(employeeId).get();
            /*ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/v1/department/" + employee1.getDepartmentCode()
                    , DepartmentDto.class);

            DepartmentDto departmentDto = responseEntity.getBody();*/

           /* DepartmentDto departmentDto = webClient.get()
                    .uri("http://localhost:8080/api/v1/department/" + employee1.getDepartmentCode())
                    .retrieve()
                    .bodyToMono(DepartmentDto.class)
                    .block();*/

            DepartmentDto departmentDto = apiClient.getDepartmentByCode(employee1.getDepartmentCode());
            EmployeeDto employeeDto = modelMapper.map(employee1, EmployeeDto.class);

            APIResponseDto apiResponseDto = new APIResponseDto();
            apiResponseDto.setEmployeeDto(employeeDto);
            apiResponseDto.setDepartmentDto(departmentDto);

            return apiResponseDto;
        }catch (Exception exception) {
            throw new EmployeeNotFoundException("This employee cannot found with this id: " + employeeId);
        }

    }
}
