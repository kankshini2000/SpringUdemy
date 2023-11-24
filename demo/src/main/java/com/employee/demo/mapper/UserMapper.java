package com.employee.demo.mapper;

import com.employee.demo.dto.UserDto;
import com.employee.demo.entity.User;

public class UserMapper {
	
	 // Convert User JPA Entity into UserDto
    //here it is for data transfer betw service to controler
	public static UserDto mapToUserDto(User user){
        UserDto userDto = new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
        return userDto;
    }

    // Convert UserDto into User JPA Entity
	//here it is for database interactions
    public static User mapToUser(UserDto userDto){
        User user = new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail()
        );
        return user;
    }
	
}
