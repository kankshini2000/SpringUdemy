package com.example.employee.service;

import java.util.List;

import com.example.employee.dto.DepartmentDto;
import com.example.employee.model.Employee;

public interface EmployeeService {

	DepartmentDto createEmp(DepartmentDto employee);
	List <DepartmentDto> getAllEmps();
	DepartmentDto getEmpId(Long eid);
	//Employee updateEmp(EmployeeDto employee,Interger eid);
	DepartmentDto updateEmp(DepartmentDto employee,Long eid);
	void deleteEmp(Long eid);
}
