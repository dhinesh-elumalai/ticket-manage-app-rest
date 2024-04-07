package com.course.me.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestDTO {

	@JsonProperty("username")
	private String email;
	
	@JsonProperty("password")
	private String password;
	
	@JsonProperty("refresh_token")
	private String refreshToken;

}
