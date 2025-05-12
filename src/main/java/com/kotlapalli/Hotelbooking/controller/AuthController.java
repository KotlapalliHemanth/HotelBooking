package com.kotlapalli.Hotelbooking.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kotlapalli.Hotelbooking.dto.Auth.LoginReqDto;
import com.kotlapalli.Hotelbooking.dto.Auth.RegisterDto;
import com.kotlapalli.Hotelbooking.services.Auth.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthService authservice;
	
	@PostMapping("/login")
	public ResponseEntity<Map<String, String>> loginUser(@RequestBody LoginReqDto userInfo) {
		System.out.println(userInfo);
		return authservice.loginUser(userInfo);
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody RegisterDto userInfo) {
		System.out.println(userInfo);
		return authservice.registerUser(userInfo);
	}
}
