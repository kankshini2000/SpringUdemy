package com.example.student.service;

import java.util.List;

import com.example.student.dto.DepartmentDto;
import com.example.student.model.Department;

public interface DepartmentService {
	DepartmentDto saveDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentByCode(String code);
	
}
