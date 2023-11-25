package com.employee.demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

@Schema(
		description = "UserDto Model Information"
		)
public class UserDto {
	
	private Long id;
    
	@Schema(
			description = "user first name"
			)
	@NotEmpty(message = "User first name should not be null or empty")
    private String firstName;
    
	@Schema(
			description = "user last name"
			)
	@NotEmpty(message = "User last name should not be null or empty")
    private String lastName;
    
	@Schema(
			description = "user email name"
			)
	@NotEmpty(message = "User email should not be null or empty")
    @Email
	private String email;

	public Long getId() {
		return id;
		
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserDto(Long id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
