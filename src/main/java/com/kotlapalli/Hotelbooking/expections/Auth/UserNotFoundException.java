package com.kotlapalli.Hotelbooking.expections.Auth;

import org.springframework.http.HttpStatus;

import com.kotlapalli.Hotelbooking.expections.ApiException;

public class UserNotFoundException extends ApiException {
    public UserNotFoundException(String message) {
        super(message, HttpStatus.CONFLICT);
    }
}
