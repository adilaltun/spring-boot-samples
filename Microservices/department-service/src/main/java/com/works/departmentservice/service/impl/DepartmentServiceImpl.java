package com.works.departmentservice.service.impl;

import com.works.departmentservice.dto.DepartmentDto;
import com.works.departmentservice.entity.Department;
import com.works.departmentservice.repository.DepartmentRepository;
import com.works.departmentservice.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public DepartmentDto save(DepartmentDto departmentDto) {

        Department department = modelMapper.map(departmentDto, Department.class);
        Department save = departmentRepository.save(department);
        DepartmentDto departmentDto1 = modelMapper.map(save, DepartmentDto.class);
        return departmentDto1;
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {

        List<Department> all = departmentRepository.findAll();
        List<DepartmentDto> getAllDepartments = all.stream().map(department -> modelMapper.map(department, DepartmentDto.class)).collect(Collectors.toList());
        return getAllDepartments;
    }

    @Override
    public DepartmentDto getDeparmentByCode(String departmentCode) {

        Department byDepartmentCodeEqualsIgnoreCase = departmentRepository.findByDepartmentCodeEqualsIgnoreCase(departmentCode);
        DepartmentDto departmentDto = modelMapper.map(byDepartmentCodeEqualsIgnoreCase, DepartmentDto.class);
        return departmentDto;
    }
}
