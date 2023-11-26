package com.example.employee.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class EmployeeDto {
	
	//direclty entnity ko expose nhi krna hai 
	//hme db mein rakhna hai sirf
	private Long eid; 
	private String ename;
	
	private String elname;
	
	private String email;

	@Override
	public String toString() {
		return "EmployeeDto [eid=" + eid + ", ename=" + ename + ", elname=" + elname + ", email=" + email + "]";
	}
	
}
