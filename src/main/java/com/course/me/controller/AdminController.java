package com.course.me.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.me.dto.UserResponseDTO;
import com.course.me.service.UserService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
		return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
	}

	@PutMapping("/users/{email}/{is-active}")
	public ResponseEntity<UserResponseDTO> modifyUserState(@PathVariable("email") String email,
			@PathVariable("is-active") boolean isActive) {
		return new ResponseEntity<>(userService.updateUserState(email, isActive), HttpStatus.OK);
	}
}
