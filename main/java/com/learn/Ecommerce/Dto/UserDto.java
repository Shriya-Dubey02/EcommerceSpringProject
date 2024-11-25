package com.learn.Ecommerce.Dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	
	private String id;
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	@NotNull
	private String emailId;
	@NotNull
	private String password;
	@NotNull
	private String confirmPassword;
	@NotNull
	private int age;

}
