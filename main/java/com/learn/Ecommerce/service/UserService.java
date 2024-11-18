package com.learn.Ecommerce.service;

import java.util.List;

import com.learn.Ecommerce.Dto.UserDto;
import com.learn.Ecommerce.entity.User;

public interface UserService {
	
	// To add user
	UserDto addUser(UserDto userDto);
	
	// To fetch all users
	List<UserDto> getAllUsers();
	
	// To fetch user by Id
	UserDto getUserById(String Id);
	
	// update user by Id
	UserDto updateUser(String id,UserDto userDto);
	
	// To delete user by id
	String deleteUser(String id);
	
	// Entity to Dto conversion
	
	UserDto entityToDto(User user);
	
	// Dto to Entity conversion
	
	User DtoToEntity(UserDto UserDto);

}
