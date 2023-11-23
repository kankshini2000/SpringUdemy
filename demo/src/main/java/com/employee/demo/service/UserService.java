package com.employee.demo.service;

import java.util.List;

import com.employee.demo.dto.UserDto;
import com.employee.demo.entity.User;

public interface UserService {
	UserDto createUser(UserDto user);
	UserDto getUserById(Long userId);
	List<UserDto> getAllUsers();
	UserDto updateUser(UserDto user);
	void deleteUser(Long userId);
}
