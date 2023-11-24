package com.example.employee.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/emp")
@AllArgsConstructor
public class EmployeeControl {
	
	private EmployeeService employeeService;
	
	@PostMapping("create")
	public ResponseEntity<Employee> create(@RequestBody Employee emp) {
		/*all the creation of employee logic is wriiten in the serviceimpl class
		 * hence when we call the employeeservice.createemp() then it executes the creation methods
		 for the mployee object i.e emp and saves it to repo and return the created employee */
		Employee createdEmp = employeeService.createEmp(emp);
		return new ResponseEntity<>(createdEmp, HttpStatus.CREATED);
	}
	
	@GetMapping("getAll")
	public ResponseEntity<List<Employee>> getAllEmployee(Employee emp){
		List<Employee> emps= employeeService.getAllEmps();
		return new ResponseEntity<List<Employee>>(emps,HttpStatus.OK);
	}
	
	@GetMapping("{eid}")
	public ResponseEntity<Employee> getAllEmpByIds(@PathVariable("eid") Long eid){
		Employee emps= employeeService.getEmpId(eid);
		return new ResponseEntity<>(emps,HttpStatus.OK);
	}
	
	@PutMapping("update/{eid}")
	public ResponseEntity<Employee> updatedEmps(@RequestBody Employee emp,@PathVariable Long eid){
		emp.setEid(eid);
		Employee existingemps= employeeService.updateEmp(emp);
		return new ResponseEntity<>(existingemps, HttpStatus.OK);
	}
	
	@DeleteMapping("del/{eid}")
	public ResponseEntity<String> deleteEmpWithId(@PathVariable("eid") Long eid) {
		employeeService.deleteEmp(eid);
		return new ResponseEntity<>("employee deleted succesfully", HttpStatus.OK) ;
	}
}
