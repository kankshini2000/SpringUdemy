package com.example.employee.service.impl;

import java.util.List;
import java.util.Optional;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.dto.DepartmentDto;
import com.example.employee.mapper.EmployeeMapper;
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
	/*📌Main logic of the program why did we convert 
	 * 1)Dto to emp 2)Emp to dto 
	 Reason=> 
	 1)hmne real information pass nhi krna hai clietn side ko isiliye sabse pehel dtoclass banaya
	 so that voh cleint side ineract kr sake aur generally dto object hi return karega if implemnted DTO clas
	 so yahan hm sabse pehele dto ko emp object mein kr rhe hai 
	 kyuki JPA repostory deals with Entity hence Employee hmne paas kiya hai JPA repostory jab convert hoga 
	 employee mein so vph database mien save hoga by employeerpostoryy ka save method .
	 
	 2)Employee mein convert hogya uske baad postman se hmane interact krna padega iske liye enity ko 
	 jpa mein convert karenge jab voh convert ho jayega usko save krnege kisi object mein  yaha p 
	 iska naam hai savedmepdto a\8nd hence as hamara return type bhi employeeDTO hai, so return bhi vahi hoga📌*/
	public DepartmentDto createEmp(DepartmentDto employeedto) {
		/*abhi here we are receiving error kyuki in the repo JPA repostory mein
		 <ENtity(employee),primary key>  Empolyee hai jabki createDto mein EmployeeDTO
		 as a paratmer paas kiya jaa rha hai so yeh EmpployeeDto koi convert krna padega
		 Employee employee k object mein
		  */
		//converting dto to emp
		Employee emp = EmployeeMapper.DtoToEmp(employeedto);
		Employee savedemp = employeeRepo.save(emp);
		
		//converting emp to dto
		DepartmentDto savedEmpDto = EmployeeMapper.emptoDto(savedemp);	
		return savedEmpDto;
	}

	@Override
	public List<DepartmentDto> getAllEmps() {
		//yahan p we are finding all the emps 
		List<Employee> emps = employeeRepo.findAll();
		/*yahan p we need to convert it into DTO objects hence, as sare employees list
		 * k isme hai isiliye hamne List<EmployeeDto> liya hai , yahan Employee ka stream banaya hai , jisme
		 * har ek Employee stream k liye we are mapping it to EmployeeDto jiska method hai 
		 * EmpToDto aaur once they are mapped ham use new list mein collect kr re hai i.e
		 * List<EmployeeDtos> mein*/
		List<DepartmentDto> empsDto = emps.stream()
				.map(EmployeeMapper::emptoDto)
				.collect(Collectors.toList());
		return empsDto;
	}

	@Override
	public DepartmentDto getEmpId(Long eid) {
		//isme we are finding empbyits id aur store kr rhe hai empbyitsid mein
		Optional<Employee> empbyitsids = employeeRepo.findById(eid);
		/*iske baad ham joh id mila hai for specific employee detials usko ham new 
		emp object mein daalenge aur get method lagayenge toh employee object pura store hoga 
		emp mein */
		Employee emp = empbyitsids.get();
		return EmployeeMapper.emptoDto(emp);
	}

	@Override
	public DepartmentDto updateEmp(DepartmentDto employee, Long eid){
	Employee existingemp = employeeRepo.findById(eid).get();
	//Employee emp = new Employee();
	existingemp.setEname(employee.getEname());
	existingemp.setElname(employee.getElname());
	existingemp.setEmail(employee.getEmail());
	System.out.println(existingemp.toString());
	Employee updatedEmp = employeeRepo.save(existingemp);
		return EmployeeMapper.emptoDto(updatedEmp);
	}

	@Override
	public void deleteEmp(Long eid) {
		employeeRepo.deleteById(eid);
	}
	
}
