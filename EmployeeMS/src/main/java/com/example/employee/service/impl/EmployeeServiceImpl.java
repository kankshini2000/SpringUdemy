package com.example.employee.service.impl;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.employee.dto.EmployeeDto;
import com.example.employee.mapper.EmployeeMapper;
import com.example.employee.model.Employee;
import com.example.employee.repo.EmployeeRepository;
import com.example.employee.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class EmployeeServiceImpl implements EmployeeService {

   // private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    private EmployeeRepository employeeRepository;

  

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

        Employee saveDEmployee = employeeRepository.save(employee);

        EmployeeDto savedEmployeeDto = EmployeeMapper.mapToEmployeeDto(saveDEmployee);

        return savedEmployeeDto;
    }



	@Override
	public EmployeeDto getEmpployeeById(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId).get();
		EmployeeDto savedEmployeeDto = EmployeeMapper.mapToEmployeeDto(employee);
		return savedEmployeeDto;
	}

    

    
}
