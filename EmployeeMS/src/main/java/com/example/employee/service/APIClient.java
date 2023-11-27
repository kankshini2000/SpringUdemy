package com.example.employee.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.employee.dto.DepartmentDto;

@FeignClient(url ="http://localhost:8085",value = "DEPARTMENT-SERVICE")
public interface APIClient {
    // Build get department rest api
    @GetMapping("api/deptartments/{department-code}")
    DepartmentDto getDepartment(@PathVariable("department-code") String departmentCode);
}
