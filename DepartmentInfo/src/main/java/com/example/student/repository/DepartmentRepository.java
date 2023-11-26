package com.example.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.student.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{
	 Department findByDepartmentCode(String departmentCode);
}
