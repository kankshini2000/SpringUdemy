package com.employee.demo.mapper;

import org.mapstruct.Mapper;

import com.employee.demo.dto.UserDto;
import com.employee.demo.entity.User;

@Mapper
public interface AutoUserMapper {
	
	UserDto mapToUserDto (User user);
	
	User mapToUser(UserDto userDto);

}
