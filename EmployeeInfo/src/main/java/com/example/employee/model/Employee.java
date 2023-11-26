package com.example.employee.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "employees")
public class Employee {
	//Added entity class
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long eid;
	//private 
	@Column(nullable = false)
	private String ename;
	
	@Column(nullable = false)
	private String elname;
	@Column(nullable = false,unique= true)
	private String email;
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", elname=" + elname + ", email=" + email + "]";
	}
	
	
}
