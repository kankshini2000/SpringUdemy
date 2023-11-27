package com.example.employee.service.impl;



import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.employee.dto.APIResponseDto;
import com.example.employee.dto.DepartmentDto;
import com.example.employee.dto.EmployeeDto;
import com.example.employee.mapper.EmployeeMapper;
import com.example.employee.model.Employee;
import com.example.employee.repo.EmployeeRepository;
import com.example.employee.service.APIClient;
import com.example.employee.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

   // private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    private EmployeeRepository employeeRepository;

    //private RestTemplate restTemplate;
    private WebClient webClient;
    
    private APIClient apiClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        
        Employee saveDEmployee = employeeRepository.save(employee);
        

        EmployeeDto savedEmployeeDto = EmployeeMapper.mapToEmployeeDto(saveDEmployee);

        return savedEmployeeDto;
    }

	@Override
	public APIResponseDto getEmpployeeById(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId).get();
//		System.out.println(employee.getDepartmentCode());
//		ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8085/api/deptartments/"+ employee.getDepartmentCode()
//	        ,DepartmentDto.class);
//		DepartmentDto departmentDto = responseEntity.getBody();
		//web cleint methods
//		 DepartmentDto departmentDto= webClient.get()
//        .uri("http://localhost:8085/api/deptartments/" + employee.getDepartmentCode())
//        .retrieve()
//        .bodyToMono(DepartmentDto.class) //to pass the reponse type
//        .block();
		
	    DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());
		
		EmployeeDto savedEmployeeDto = EmployeeMapper.mapToEmployeeDto(employee);
		
		APIResponseDto apiResponseDto = new APIResponseDto();
		apiResponseDto.setEmployee(savedEmployeeDto);
		//yeh departmentdto objhect department k class se aa rha hia jiska hme DTO banya hai
		apiResponseDto.setDepartment(departmentDto);
		return apiResponseDto;
	}


    
}
