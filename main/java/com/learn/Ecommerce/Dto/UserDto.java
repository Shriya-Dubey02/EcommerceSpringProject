package com.learn.Ecommerce.Dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	
	private String id;
	private String firstName;
	private String lastName;
	private String emailId;
	private String password;
	private String confirmPassword;
	private int age;

}
