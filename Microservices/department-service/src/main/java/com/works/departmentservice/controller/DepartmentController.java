package com.works.departmentservice.controller;

import com.works.departmentservice.dto.DepartmentDto;
import com.works.departmentservice.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<DepartmentDto> save(@RequestBody DepartmentDto departmentDto) {
        DepartmentDto save = departmentService.save(departmentDto);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartments() {
        List<DepartmentDto> allDepartments = departmentService.getAllDepartments();
        return new ResponseEntity<>(allDepartments,HttpStatus.OK);
    }

    @GetMapping("{departmentCode}")
    public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable String departmentCode) {
        DepartmentDto deparmentByCode = departmentService.getDeparmentByCode(departmentCode);
        return new ResponseEntity<>(deparmentByCode,HttpStatus.OK);
    }
}
