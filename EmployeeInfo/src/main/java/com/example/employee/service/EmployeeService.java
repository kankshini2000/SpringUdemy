package com.example.employee.service;

import java.util.List;

import com.example.employee.model.Employee;

public interface EmployeeService {

	Employee createEmp(Employee employee);
	List <Employee> getAllEmps();
	Employee getEmpId(Long eid);
	Employee updateEmp(Employee employee);
	void deleteEmp(Long eid);
}
