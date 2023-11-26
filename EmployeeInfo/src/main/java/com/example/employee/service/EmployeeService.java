package com.example.employee.service;

import java.util.List;

import com.example.employee.dto.EmployeeDto;
import com.example.employee.model.Employee;

public interface EmployeeService {

	EmployeeDto createEmp(EmployeeDto employee);
	List <EmployeeDto> getAllEmps();
	EmployeeDto getEmpId(Long eid);
	//Employee updateEmp(EmployeeDto employee,Interger eid);
	EmployeeDto updateEmp(EmployeeDto employee,Long eid);
	void deleteEmp(Long eid);
}
