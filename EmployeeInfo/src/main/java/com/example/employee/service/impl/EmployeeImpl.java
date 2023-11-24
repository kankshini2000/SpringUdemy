package com.example.employee.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepo;
import com.example.employee.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
/*here allargsconst generates a constructor of empserviceimpl so that it can take 
 * employeerepo as its parameter.*/
public class EmployeeImpl implements EmployeeService{

	private EmployeeRepo employeeRepo;
	@Override
	public Employee createEmp(Employee employee) {
		return employeeRepo.save(employee);
	}

	@Override
	public List<Employee> getAllEmps() {
		// TODO Auto-generated method stub
		return employeeRepo.findAll();
	}

	@Override
	public Employee getEmpId(Long eid) {
		// TODO Auto-generated method stub
		//the use of opetionak is to avoid null pointer exeltion as the result may or may not exist
		Optional <Employee> optionalemp= employeeRepo.findById(eid);
		/*here get() retreieves the value insisde the opetional if it is present , 
		if not present it will throw no such element found*/
		Employee emp = optionalemp.get();
		return emp;
	}

	@Override
	public Employee updateEmp(Employee employee) {
		Employee existemp= employeeRepo.findById(employee.getEid()).get();
		existemp.setEname(employee.getEname());
		existemp.setElname(employee.getElname());
		existemp.setEmail(employee.getEmail());
		return existemp;
	}

	@Override
	public void deleteEmp(Long eid) {
		employeeRepo.deleteById(eid);;
	}

}
