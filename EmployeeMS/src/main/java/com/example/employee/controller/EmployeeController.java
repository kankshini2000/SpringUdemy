package com.example.employee.controller;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.employee.dto.EmployeeDto;
import com.example.employee.service.EmployeeService;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    
    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
  public ResponseEntity<EmployeeDto> getEmployee(@PathVariable("id")  Long employeeId){
	  EmployeeDto employeeDto = employeeService.getEmpployeeById(employeeId);
	  return new ResponseEntity<>(employeeDto, HttpStatus.OK);
  }
   
}
