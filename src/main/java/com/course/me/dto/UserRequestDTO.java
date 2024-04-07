package com.course.me.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRequestDTO {

	@NotBlank(message = "Name cannot be null")
	private String name;
	
	@NotBlank(message = "Email cannot be null")
//	@Pattern(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$", message = "Invalid Email Format!!")
	private String email;
	
	private String department;
	
	/**
	 * 	^                 # start-of-string
		(?=.*[0-9])       # a digit must occur at least once
		(?=.*[a-z])       # a lower case letter must occur at least once
		(?=.*[A-Z])       # an upper case letter must occur at least once
		(?=.*[@#$%^&+=])  # a special character must occur at least once
		(?=\S+$)          # no whitespace allowed in the entire string
		.{8,}             # anything, at least eight places though
		$                 # end-of-string
	 */
	@NotNull(message ="Password cannot be null")
	@Length(min = 8, max = 16, message = "Password Length is not valid. Must be between 8-16")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "Password must contain 1 Upper case, 1 lower case, 1 special character and 1 number")
	private String password;
	
	@NotNull(message ="Confirm Password cannot be null")
	private String confirmPassword;

	public UserRequestDTO(@NotBlank(message = "Name cannot be null") String name,
			@NotBlank(message = "Email cannot be null") @Pattern(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$", message = "Invalid Email Format!!") String email,
			String department,
			@NotNull(message = "Password cannot be null") @Length(min = 8, max = 16, message = "Password Length is not valid. Must be between 8-16") @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "Password must contain 1 Upper case, 1 lower case, 1 special character and 1 number") String password,
			@NotNull(message = "Confirm Password cannot be null") String confirmPassword) {
		super();
		this.name = name;
		this.email = email;
		this.department = department;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}

	
}
