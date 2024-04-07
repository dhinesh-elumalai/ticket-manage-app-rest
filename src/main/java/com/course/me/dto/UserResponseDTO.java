package com.course.me.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {
	
	private String name;
	
	private String email;
	
	private String department;
	
	private boolean isActive;
	
	private Set<String> roles;
}
