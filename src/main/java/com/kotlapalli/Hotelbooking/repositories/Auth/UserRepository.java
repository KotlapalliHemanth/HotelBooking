package com.kotlapalli.Hotelbooking.repositories.Auth;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kotlapalli.Hotelbooking.models.Auth.User;

public interface UserRepository extends JpaRepository<User, Long>{

	@Query("SELECT u FROM User u WHERE u.email = :input OR u.username = :input")
	Optional<User> findByEmailOrUsername(String input);
	
	boolean existsByEmail(String email);

	boolean existsByUsername(String username);
	
	boolean existsByNumber(String number);
}
