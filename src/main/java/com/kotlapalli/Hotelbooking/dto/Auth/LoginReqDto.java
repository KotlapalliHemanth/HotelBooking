package com.kotlapalli.Hotelbooking.dto.Auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kotlapalli.Hotelbooking.models.Auth.Role;

import lombok.Data;

@Data
public class LoginReqDto {
	
	@JsonProperty("uNameEmail")
	private String uNameEmail;
	
	private String password;
	
	private Role role;
}
