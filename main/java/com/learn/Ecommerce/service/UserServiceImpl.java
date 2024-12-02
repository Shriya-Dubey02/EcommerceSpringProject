package com.learn.Ecommerce.service;


import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.Ecommerce.Dto.UserDto;
import com.learn.Ecommerce.entity.User;
import com.learn.Ecommerce.repository.UserRepository;

import jakarta.websocket.server.ServerEndpoint;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDto addUser(UserDto userDto) {
		// UUID provides a unique id for every object
		// randomUUID is a static method 
		UUID randomUUID=UUID.randomUUID();
		String id=randomUUID.toString();
		userDto.setId(id);
		
		User user = DtoToEntity(userDto);
		User savedUser = userRepository.save(user);
		
	    UserDto savedDto = entityToDto(savedUser);
		
		return savedDto;
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = userRepository.findAll();
		// we cannot convert list of objects to dto so we called map. It will go to every object and convert it
		// return mai we don't want stream so collect is used
		List<UserDto> userDtoList = users.stream().map(u->entityToDto(u)).collect(Collectors.toList());
		
		return userDtoList;
	}

	@Override
	public UserDto getUserById(String Id) {

		// it gives optinal return type but we want user so we will throw an exception
		User user=userRepository.findById(Id).orElseThrow(()->new RuntimeException(Id +" not found"));
		return entityToDto(user);
	}

	@Override
	public UserDto updateUser(String id, UserDto userDto) {
		User user=userRepository.findById(id).orElseThrow(()->new RuntimeException(id+" not found"));
		
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setEmailId(userDto.getEmailId());
		user.setAge(userDto.getAge());
		user.setPassword(userDto.getPassword());
		
		// saves the user in the database
		User updateUser=userRepository.save(user);
		
		return entityToDto(updateUser) ;
	}

	@Override
	public String deleteUser(String Id) {
		User user=userRepository.findById(Id).orElseThrow(()->new RuntimeException(Id+ " not found") );
		
		userRepository.delete(user);
		return user.getId()+"deleted successfully";
	}

	@Override
	public UserDto entityToDto(User user) {
		UserDto userdto=new UserDto();
		userdto.setId(user.getId());
		userdto.setFirstName(user.getFirstName());
		userdto.setLastName(user.getLastName());
		userdto.setEmailId(user.getEmailId());
		userdto.setAge(user.getAge());
		userdto.setPassword(user.getPassword());
		userdto.setAddress(user.getAddress());
		return userdto;
	}

	@Override
	public User DtoToEntity(UserDto UserDto) {
		
		User user=new User();
		user.setId(UserDto.getId());
		user.setFirstName(UserDto.getFirstName());
		user.setLastName(UserDto.getLastName());
		user.setEmailId(UserDto.getEmailId());
		user.setAge(UserDto.getAge());
		user.setPassword(UserDto.getPassword());
		user.setAddress(UserDto.getAddress());
		
		return user;
	}
	// Implementation class of userService
	
	

	@Override
	public UserDto getUserByEmail(String email) 
	{
		User user= userRepository.findByEmailId(email).orElseThrow(()->new RuntimeException(email+" not found"));
		return entityToDto(user);
	}

	@Override
	public List<UserDto> getuserByFirstName(String firstName) {
		List<User> users= userRepository.findByFirstName(firstName);
		List<UserDto> userDtolist=users.stream().map(u->entityToDto(u)).collect(Collectors.toList());
		return userDtolist;
	}

	
	
	

}
