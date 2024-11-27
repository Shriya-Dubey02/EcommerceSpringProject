package com.learn.Ecommerce.Dto;

import com.learn.Ecommerce.validators.PasswordMatch;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@PasswordMatch
public class UserDto {
	
	private String id;
	@NotNull
	@NotBlank(message= "firstname cannot be blank")
	@Size(min = 2, max =25, message="max length allowed is 25")
	private String firstName;
	@NotNull
	@NotBlank(message= "lastname cannot be blank")
	@Size(min=2, max=40)
	private String lastName;
	@NotNull
	@NotBlank(message = "lastname cannot be blank")
	@Pattern(regexp="^((?!\\.)[\\w\\-_.]*[^.])(@\\w+)(\\.\\w+(\\.\\w+)?[^.\\W])$")
	private String emailId;
	@NotNull
	@NotBlank
	@Pattern(regexp= "^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[^\\w\\d\\s:])([^\\s]){8,16}$") // for strict passwords
	private String password;
	@NotNull 
	@NotBlank // will not allow blank values
	private String confirmPassword;
	@NotNull
	@Min(12)
	@Max(120)
	private int age;

}
