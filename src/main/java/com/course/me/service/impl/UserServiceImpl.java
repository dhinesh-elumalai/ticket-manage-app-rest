package com.course.me.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.course.me.dto.LoginRequestDTO;
import com.course.me.dto.LoginResponseDTO;
import com.course.me.dto.UserRequestDTO;
import com.course.me.dto.UserResponseDTO;
import com.course.me.exception.TicketException;
import com.course.me.model.User;
import com.course.me.repo.UserRepository;
import com.course.me.service.UserService;

@Service
public class UserServiceImpl implements UserService, UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<User> userOpt = userRepository.findByEmail(username);
		
		if(userOpt.isPresent()) {
			Set<GrantedAuthority> authorities = new HashSet<>();
			userOpt.get().getRoles().forEach((role)->{
				GrantedAuthority authority = ()->role;
				authorities.add(authority);
			});
			org.springframework.security.core.userdetails.User
														.builder()
													    .username(username)
													    .password(userOpt.get().getPassword())
													    .authorities(authorities).build();
		}
		
		throw new UsernameNotFoundException("Invalid Email Id / Username not present");
		
	}

	@Override
	public String createUser(UserRequestDTO userRequestDto) {
		if(!userRequestDto.getPassword().equals(userRequestDto.getConfirmPassword())) {
			throw new TicketException(HttpStatus.BAD_REQUEST, "Password and confirm password must be same", null);
		}
		
		User userSaved = userRepository.save(convertUserRequestToUser(userRequestDto));
		
		return "User with username : " + userSaved.getEmail() +" has been created successsfully";
	}

	@Override
	public List<UserResponseDTO> getAllUsers() {
		return userRepository.findAll().stream().map(this::convertToUserResponse).collect(Collectors.toList());
	}

	@Override
	public UserResponseDTO updateUserState(String email, boolean isActive) {
		Optional<User> userOpt = userRepository.findByEmail(email);
		if(userOpt.isPresent()) {
			User userFound = userOpt.get();
			userFound.setActive(isActive);
			User userSaved = userRepository.save(userFound);
			return this.convertToUserResponse(userSaved);
		}
		return null;
	}

	@Override
	public UserResponseDTO getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 * @param userRequestDto
	 * @return
	 */
	public User convertUserRequestToUser(UserRequestDTO userRequestDto) {
		User user = new User();
		user.setActive(false);
		user.setDepartment(userRequestDto.getDepartment());
		user.setEmail(userRequestDto.getEmail());
		user.setName(userRequestDto.getName());
		user.setRoles(new HashSet<String>());
		user.setPassword(bCryptPasswordEncoder.encode(userRequestDto.getPassword()));
		return user;
	}
	
	/**
	 * This method is used to convert User entity to response
	 * 
	 * @param userSaved
	 * @return
	 */
	public UserResponseDTO convertToUserResponse(User userSaved) {
		UserResponseDTO userResponseDTO = new UserResponseDTO();
		userResponseDTO.setActive(userSaved.isActive());
		userResponseDTO.setDepartment(userSaved.getDepartment());
		userResponseDTO.setName(userSaved.getName());
		userResponseDTO.setEmail(userSaved.getEmail());
		userResponseDTO.setRoles(userSaved.getRoles());
		return userResponseDTO;
	}
}
