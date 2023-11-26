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

import com.example.employee.dto.DepartmentDto;
import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/emp")
@AllArgsConstructor
public class EmployeeControl {
	
	private EmployeeService employeeService;
	
	@PostMapping("create")
	public ResponseEntity<DepartmentDto> create(@RequestBody DepartmentDto empdto) {
		/*all the creation of employee logic is wriiten in the serviceimpl class
		 * hence when we call the employeeservice.createemp() then it executes the creation methods
		 for the mployee object i.e emp and saves it to repo and return the created employee */
		DepartmentDto createdEmp = employeeService.createEmp(empdto);
		return new ResponseEntity<>(createdEmp, HttpStatus.CREATED);
	}
	
	@GetMapping("getAll")
	public ResponseEntity<List<DepartmentDto>> getAllEmployee(DepartmentDto empdto){
		List<DepartmentDto> empsdto= employeeService.getAllEmps();
		return new ResponseEntity<List<DepartmentDto>>(empsdto,HttpStatus.OK);
	}
	
	@GetMapping("{eid}")
	public ResponseEntity<DepartmentDto> getAllEmpByIds(@PathVariable("eid") Long eid){
		DepartmentDto empsdto= employeeService.getEmpId(eid);
		return new ResponseEntity<>(empsdto,HttpStatus.OK);
	}
	
	@PutMapping("update/{eid}")
	public ResponseEntity<DepartmentDto> updatedEmps(@RequestBody DepartmentDto empdto,@PathVariable("eid") Long eid){
		//to make sure ki ham correct eid mein sab changes kr rhe hai
		empdto.setEid(eid);
		System.out.println(empdto.toString());
		DepartmentDto existingemps= employeeService.updateEmp(empdto, eid);
		return new ResponseEntity<>(existingemps, HttpStatus.OK);
	}
	
	@DeleteMapping("del/{eid}")
	public ResponseEntity<String> deleteEmpWithId(@PathVariable("eid") Long eid) {
		employeeService.deleteEmp(eid);
		return new ResponseEntity<>("employee deleted succesfully", HttpStatus.OK) ;
	}
}
