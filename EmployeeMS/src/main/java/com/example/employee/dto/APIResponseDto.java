package com.example.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class APIResponseDto {
	
	//her we need to send the object i.e department wala aur dto object wala
    private EmployeeDto employee;
    private DepartmentDto department;
    //private OrganizationDto organization;
}
