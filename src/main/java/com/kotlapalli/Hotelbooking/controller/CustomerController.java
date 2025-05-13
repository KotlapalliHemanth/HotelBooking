package com.kotlapalli.Hotelbooking.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@GetMapping("/details")
	public ResponseEntity<String> getUserProfile(Authentication authentication) {
//		String username = authentication.getName();
		
		return ResponseEntity.ok("result" );
	}
}
