package com.employee.demo.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.employee.demo.dto.UserDto;
import com.employee.demo.entity.User;
import com.employee.demo.exception.ErrorDetails;
import com.employee.demo.exception.ResourceNotFoundException;
import com.employee.demo.service.UserService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UserController {

//	@Autowired
	private UserService userService;
	
	@PostMapping 
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user){
		UserDto savedUser = userService.createUser(user);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId){
        UserDto user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
	
	@GetMapping("all")
	public ResponseEntity<List<UserDto>> getAllUser(){
		List<UserDto> user = userService.getAllUsers();
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@PutMapping("update/{id}")
	public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId,@RequestBody @Valid UserDto user){
		user.setId(userId);
		UserDto updatedUser = userService.updateUser(user);
		return new ResponseEntity<>(updatedUser,  HttpStatus.OK);
	}
	
	//DeleteMapping
	@DeleteMapping("del/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId) {
		userService.deleteUser(userId);
		return new ResponseEntity<>("User deleted successfully!!",HttpStatus.OK);
	}

//	@ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception,                                                             WebRequest webRequest){
//     ErrorDetails errorDetails = new ErrorDetails(
//             LocalDateTime.now(),
//             exception.getMessage(),
//             webRequest.getDescription(false),
//             "USER_NOT_FOUND"
//     );
//     return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
//  }	
}
