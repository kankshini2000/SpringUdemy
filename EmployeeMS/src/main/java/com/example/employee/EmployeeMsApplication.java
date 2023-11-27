package com.example.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableFeignClients
public class EmployeeMsApplication {

	/*yeh method return karega instance of a class*/
//	@Bean
//	public RestTemplate restTemplate(){
//		return new RestTemplate();
//	}
	
	@Bean
	public WebClient webClient(){
		return WebClient.builder().build();
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(EmployeeMsApplication.class, args);
	}

}
