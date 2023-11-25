package com.employee.demo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.models.annotations.OpenAPI30;

@SpringBootApplication
@OpenAPIDefinition(
		info=@Info(
				title = "User REST API Documentation",
				description = "Spring boot rest api documentation",
		         version= "v1.0",
		         contact = @Contact(
				name ="Createdby_me",
				email="miumiu@gmail.com",
				url= "https://www.w3schools.com/"
				),
		         license = @License(
		        			name= "Apache 2.0",
		    				url ="https://www.w3schools.com/")
		),
		externalDocs = @ExternalDocumentation(
				description= "spring boot user manageemnt documentation",
				url = "https://www.w3schools.com/"
						 )
)
public class DemoApplication {
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
