package com.employee.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.employee.demo.dto.UserDto;
import com.employee.demo.entity.User;

@Mapper
public interface AutoUserMapper {
	
	
	AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);
	
	//@Mapping(source = "email", target="emailAddress")
	
	UserDto mapToUserDto (User user);
	
	User mapToUser(UserDto userDto);

}
