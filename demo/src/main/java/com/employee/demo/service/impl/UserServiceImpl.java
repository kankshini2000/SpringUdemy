package com.employee.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.employee.demo.entity.User;
import com.employee.demo.repository.UserRepository;
import com.employee.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	//created an instance varible injecting reporsitory
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public User getUserById(Long userId) {
		// TODO Auto-generated method stub
		Optional<User> optionalUser = userRepository.findById(userId);
		return optionalUser.get();
	}

	@Override
	public  List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User updateUser(User user) {
		User existingUser = userRepository.findById(user.getId()).get();
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
	    existingUser.setEmail(user.getEmail());
	    User updatedUser = userRepository.save(existingUser);
		return updatedUser;
	}

	@Override
	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
	}

}
