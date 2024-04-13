package com.course.me.service;

import java.util.List;

//import org.springframework.security.core.userdetails.UserDetailsService;


import com.course.me.dto.LoginRequestDTO;
import com.course.me.dto.LoginResponseDTO;
import com.course.me.dto.UserRequestDTO;
import com.course.me.dto.UserResponseDTO;

public interface UserService {

	public String createUser(UserRequestDTO userRequestDto);
	
	public List<UserResponseDTO> getAllUsers();
	
	public UserResponseDTO updateUserState(String email, boolean isActive);
	
	public UserResponseDTO getUserByEmail(String email);
	
	public LoginResponseDTO login(LoginRequestDTO loginRequestDTO);
}
