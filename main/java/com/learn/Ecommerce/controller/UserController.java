package com.learn.Ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.Ecommerce.Dto.UserDto;
import com.learn.Ecommerce.service.UserService;
import com.learn.Ecommerce.service.UserServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

@Autowired	
UserService userService;	
// response entity	
// POST ["/users"] To add user
@PostMapping // valid is used to not allow null values
public ResponseEntity<UserDto> addUser(@RequestBody @Valid UserDto userDto)
{
	UserDto savedUser= userService.addUser(userDto);
	return new ResponseEntity<UserDto>(savedUser,HttpStatus.CREATED);
	
}

// GET ["/user/{101}"] to fetch user by id

@GetMapping("/{id}")
public ResponseEntity<UserDto> getUserById(@PathVariable String id)
{
	UserDto userDto=userService.getUserById(id);
	return new ResponseEntity<UserDto>(userDto,HttpStatus.FOUND);
}

// GET ["/users"] to fetch all users

@GetMapping
public ResponseEntity<List<UserDto>> fetchAllUsers()
{
	List<UserDto> users = userService.getAllUsers();
	return new ResponseEntity<List<UserDto>>(users,HttpStatus.OK);
}

@DeleteMapping("/{Id}")
public ResponseEntity<String> deleteUserById(@PathVariable String Id)
{
	String message = userService.deleteUser(Id);
	return new ResponseEntity<String>(message,HttpStatus.OK);
	
}
// PUT {"/users/{id}"} update user

@PutMapping("/{id}")
public ResponseEntity<UserDto> updateUser(@PathVariable String id, @RequestBody UserDto userDto)
{
	UserDto updateUser = userService.updateUser(id, userDto);
	return new ResponseEntity<UserDto>(updateUser,HttpStatus.OK);

}

@GetMapping("find-by-email/{emailId}")
public ResponseEntity<UserDto> getUserByemail(@PathVariable String emailId)
{
	// UserDto userdto= userService.getUserByEmail(email);
	return new ResponseEntity<UserDto>(userService.getUserByEmail(emailId),HttpStatus.FOUND);
}

@GetMapping("find-by-firstname")
public ResponseEntity<List<UserDto>> getUsersByFirstName(@RequestParam String fname)
{
	return new ResponseEntity<List<UserDto>>(userService.getuserByFirstName(fname),HttpStatus.FOUND);
}
}
