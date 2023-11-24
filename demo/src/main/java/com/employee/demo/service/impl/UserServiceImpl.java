package com.employee.demo.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.employee.demo.dto.UserDto;
import com.employee.demo.entity.User;
import com.employee.demo.mapper.AutoUserMapper;
import com.employee.demo.mapper.UserMapper;
import com.employee.demo.repository.UserRepository;
import com.employee.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	//created an instance varible injecting reporsitory
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		// TODO Auto-generated method stub
		/*convert UserDto object into UserJPA entity object and pass that User entity object
		to this save() method*/
		//User user = UserMapper.mapToUser(userDto);
		//User user = modelMapper.map(userDto, User.class);
		
		User user = AutoUserMapper.MAPPER.mapToUser(userDto);
		/* Save the User entity object to the repository basically
		 maptOUser i.e for database we use JPA entities as the user is geeting
		 stored in the database hence "mapToUser is used*/
		 User savedUser= userRepository.save(user);
		 
		 //Convert the saved User JPA entity to a UserDto and return it
		 /*here mapUsertoDto is being used bcoz this DTO object is generally done between
		  service n controller layer,hence as we have saved that savedUser (i.e from database) we 
		  will send request to the client to createUser so client side is being used
		  hence when did postman to send request to createUser() it get converted into
		  UserDTo*/
		 //UserDto savedUserDto= UserMapper.mapToUserDto(savedUser);
		 //UserDto savedUserDto = modelMapper.map(savedUser, UserDto.class);
		 
		 UserDto savedUserDto = AutoUserMapper.MAPPER.mapToUserDto(savedUser);
		 return savedUserDto;
		 
		 //convert userJPA entity to userDTO
	}

	@Override
	public UserDto getUserById(Long userId) {
		// TODO Auto-generated method stub
		Optional<User> optionalUser = userRepository.findById(userId);
		User user = optionalUser.get();
		//return UserMapper.mapToUserDto(user);
		
		return AutoUserMapper.MAPPER.mapToUserDto(optionalUser.get());
		
		//return modelMapper.map(user, UserDto.class);
	}

	@Override
	public  List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> users = userRepository.findAll();
//		//return users.stream().map(UserMapper::mapToUserDto)
//				.collect(Collectors.toList());
		return users.stream().map((user)-> AutoUserMapper.MAPPER.mapToUserDto(user))
				.collect(Collectors.toList());
		//
		//return users.stream().map((user)->modelMapper.map(user, UserDto.class))
				//her map takes functional interface hence lambda expression is used.
	}

	@Override
	public UserDto updateUser(UserDto user) {
		User existingUser = userRepository.findById(user.getId()).get();
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
	    existingUser.setEmail(user.getEmail());
	    User updatedUser = userRepository.save(existingUser);
		//return UserMapper.mapToUserDto(updatedUser);
	    //return modelMapper.map(updatedUser, UserDto.class);
	    return AutoUserMapper.MAPPER.mapToUserDto(updatedUser);
	}

	@Override
	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
	}

}
