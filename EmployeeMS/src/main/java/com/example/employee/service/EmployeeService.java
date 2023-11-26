package com.example.employee.service;

import com.example.employee.dto.EmployeeDto;

public interface EmployeeService {
	
	 EmployeeDto saveEmployee(EmployeeDto employeeDto);

	 EmployeeDto getEmpployeeById(Long employeeId);
	 //APIResponseDto getEmployeeById(Long employeeId);
}
