package com.kotlapalli.Hotelbooking.dto.Auth;


import com.kotlapalli.Hotelbooking.models.Auth.Role;

import lombok.Data;

@Data
public class RegisterDto {
	
//	validations should be done in frontEnd
	
	private String username;
	
	private String email;
	
	private String number;
	
	private String password;
	
	private Role role;
}
