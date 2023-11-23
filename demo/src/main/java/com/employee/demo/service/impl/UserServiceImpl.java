package com.employee.demo.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.employee.demo.dto.UserDto;
import com.employee.demo.entity.User;
import com.employee.demo.mapper.UserMapper;
import com.employee.demo.repository.UserRepository;
import com.employee.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	//created an instance varible injecting reporsitory
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		// TODO Auto-generated method stub
		/*convert UserDto object into UserJPA entity object and pass that User entity object
		to this save() method*/
		User user = UserMapper.mapToUser(userDto);
		//not wrote return as we need to return UserDto obejct
		 User savedUser= userRepository.save(user);
		 
		 UserDto savedUserDto= UserMapper.mapToUserDto(savedUser);
		 return savedUserDto;
		 
		 //convert userJPA entity to userDTO
	}

	@Override
	public UserDto getUserById(Long userId) {
		// TODO Auto-generated method stub
		Optional<User> optionalUser = userRepository.findById(userId);
		User user = optionalUser.get();
		return UserMapper.mapToUserDto(user);
	}

	@Override
	public  List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> users = userRepository.findAll();
		return users.stream().map(UserMapper::mapToUserDto)
				.collect(Collectors.toList());
	}

	@Override
	public UserDto updateUser(UserDto user) {
		User existingUser = userRepository.findById(user.getId()).get();
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
	    existingUser.setEmail(user.getEmail());
	    User updatedUser = userRepository.save(existingUser);
		return UserMapper.mapToUserDto(updatedUser);
	}

	@Override
	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
	}

}
