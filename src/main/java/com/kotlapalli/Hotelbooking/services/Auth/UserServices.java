package com.kotlapalli.Hotelbooking.services.Auth;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kotlapalli.Hotelbooking.dto.Auth.LoginReqDto;
import com.kotlapalli.Hotelbooking.dto.Auth.RegisterDto;
import com.kotlapalli.Hotelbooking.expections.Auth.UserAlreadyExistsException;
import com.kotlapalli.Hotelbooking.models.Auth.User;
import com.kotlapalli.Hotelbooking.repositories.Auth.UserRepository;


@Service
public class UserServices {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public void createUserRecord(RegisterDto RegUser) {
		if(userRepository.existsByEmail(RegUser.getEmail())) {
			throw new UserAlreadyExistsException("Email is already in use.");
		}
		
		if(userRepository.existsByUsername(RegUser.getUsername())) {
			throw new UserAlreadyExistsException("user name is already in Use");
		}
		
		if(userRepository.existsByNumber(RegUser.getNumber())) {
			throw new UserAlreadyExistsException("Moile Number is already in Use");
		}
		if(RegUser.getRole().name().equalsIgnoreCase("admin")) {
			throw new UserAlreadyExistsException("Invalid Request");
		}
		
		User user= new User();
		user.setUsername(RegUser.getUsername());
		user.setEmail(RegUser.getEmail());
		user.setNumber(RegUser.getNumber());
		user.setPassword(passwordEncoder.encode(RegUser.getPassword()));
		user.setRole(RegUser.getRole());
		userRepository.save(user);
	}
	
	public Optional<User> getUserInfo(LoginReqDto Loginuser) {
		return (userRepository.findByEmailOrUsername(Loginuser.getUNameEmail()));
	}
}
