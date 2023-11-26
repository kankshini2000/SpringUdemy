package com.example.employee.mapper;

import com.example.employee.dto.DepartmentDto;
import com.example.employee.model.Employee;

public class EmployeeMapper {
	/*yahan p Return type Employee isisliye hai kyuki hm dto koi entity mein convert kr rhe hai
	dto ka data joh client side se milega usko aise entity form mein store krna padega taki voh 
	database mein persist reh sake */
	public static Employee DtoToEmp(DepartmentDto empdto) {
		Employee emp = new Employee();
		//dto se joh infromation aayegi usko hm set krenege apne entity k liye
		emp.setEid(empdto.getEid());
        emp.setEname(empdto.getEname());
        emp.setElname(empdto.getElname()); // Set elname from the DTO
        emp.setEmail(empdto.getEmail());
        return emp;
	}
	
	/*📌Important point note krna hai jab bhi moadelmapper use krne
	 * aur method likheneg tab usme, hamesh return type yaad rakhna uske hisab se retur  hoga
	 * jaise yahan p emp ko dto mein convert krna hai isiluye iska return type empdto hai hence 
	 * usi k hisab se empdto ka naya instance create hoa taki ham log employee k details get krke
	 * usko empdto mein set kre and vaise empdto ka form return ho
	 * 📌*/
	//yahan p we are converting emp entity to dto mein
	public static DepartmentDto emptoDto(Employee employee) {
		DepartmentDto empdto = new DepartmentDto();
		/*yahan p empdto isiliye return type hai kyuki hame entity ko dto mein convert krna hai,  
         */
		empdto.setEid(employee.getEid());
		empdto.setEname(employee.getEname());
		empdto.setElname(employee.getElname());
		empdto.setEmail(employee.getEmail());
		return empdto;
	}
}
