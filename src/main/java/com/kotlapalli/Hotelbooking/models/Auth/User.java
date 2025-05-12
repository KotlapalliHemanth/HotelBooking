package com.kotlapalli.Hotelbooking.models.Auth;

import java.time.LocalDate;

import jakarta.persistence.*;

import lombok.Data;

@Data
@Entity
public class User {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable = false, unique = true)
    private String username;
	
	@Column(nullable = false, unique = true)
    private String email;
	
	@Column(nullable = false, unique = true)
    private String number;
	@Column(nullable = false)
    private String password;

    private String gender; // optional
    private LocalDate dateOfBirth; // optional

    @Column(nullable = false)
    private Role role;
    private String picture;
}
