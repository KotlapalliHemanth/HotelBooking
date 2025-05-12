package com.kotlapalli.Hotelbooking.dto.Auth;

import com.kotlapalli.Hotelbooking.models.Auth.Role;

import lombok.Data;

@Data
public class LoginReqDto {

	private String uNameOrEmail;
	
	private String password;
	
	private Role role;
}
