package com.kotlapalli.Hotelbooking.expections.JwtExpection;

import org.springframework.http.HttpStatus;

import com.kotlapalli.Hotelbooking.expections.ApiException;

public class JwtValidationException extends ApiException {
	public JwtValidationException(String message) {
		super(message, HttpStatus.CONFLICT);
	}
}
