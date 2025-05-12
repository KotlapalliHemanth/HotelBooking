package com.kotlapalli.Hotelbooking.services.Auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.kotlapalli.Hotelbooking.dto.Auth.LoginReqDto;
import com.kotlapalli.Hotelbooking.dto.Auth.RegisterDto;
import com.kotlapalli.Hotelbooking.expections.Auth.UserNotFoundException;
import com.kotlapalli.Hotelbooking.models.Auth.User;
import com.kotlapalli.Hotelbooking.security.Jwt.JwtUtill;

@Service
public class AuthService {

	@Autowired
	private UserServices userservice;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtUtill Jutil;
	
//	use BindingResult only when the validation is reqired for the Dto
	public ResponseEntity<String> registerUser( RegisterDto Userinfo) {
		
		userservice.createUserRecord(Userinfo);
		return ResponseEntity.ok("User registration Sucessfull");
		
	}
	
	public ResponseEntity<Map<String, String>> loginUser(LoginReqDto userinfo) {
		User user=userservice.getUserInfo(userinfo).orElseThrow(()->new UserNotFoundException("Invalid Username or Email"));
		if(!passwordEncoder.matches(userinfo.getPassword(), user.getPassword())) {
			throw new UserNotFoundException("Invalid password");
		}
		Map<String, String> response = new HashMap<>();
        response.put("token", Jutil.generateAccessTokken(user));
        return ResponseEntity.ok(response);
	}
	
}
