package com.course.me.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.me.dto.LoginRequestDTO;
import com.course.me.dto.LoginResponseDTO;
import com.course.me.dto.UserRequestDTO;
import com.course.me.dto.UserResponseDTO;
import com.course.me.model.User;
import com.course.me.repo.UserRepository;
import com.course.me.service.UserService;

@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/signup")
	public ResponseEntity<String> createUser(@Valid @RequestBody UserRequestDTO userRequestDTO) {
		System.out.println("User : "+ userRequestDTO);
		return new ResponseEntity<>(userService.createUser(userRequestDTO), HttpStatus.CREATED);
	}
	
	@PostMapping("/login/token")
	public ResponseEntity<LoginResponseDTO> loginGetToken(@Valid @RequestBody LoginRequestDTO loginRequestDTO) {
		return new ResponseEntity<>(userService.login(loginRequestDTO), HttpStatus.CREATED);
	}
	
	@PostMapping("/login/refresh-token")
	public ResponseEntity<LoginResponseDTO> refreshToken(@Valid @RequestBody LoginRequestDTO loginRequestDTO) {
		return new ResponseEntity<>(userService.login(loginRequestDTO), HttpStatus.CREATED);
	}
}
