package com.works.departmentservice.service;

import com.works.departmentservice.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {

    DepartmentDto save (DepartmentDto departmentDto);

    List<DepartmentDto> getAllDepartments();

    DepartmentDto getDeparmentByCode(String departmentCode);

}
