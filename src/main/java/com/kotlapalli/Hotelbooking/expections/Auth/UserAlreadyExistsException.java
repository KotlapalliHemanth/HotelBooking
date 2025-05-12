package com.kotlapalli.Hotelbooking.expections.Auth;

import org.springframework.http.HttpStatus;

import com.kotlapalli.Hotelbooking.expections.ApiException;

public class UserAlreadyExistsException extends ApiException {
    public UserAlreadyExistsException(String message) {
        super(message, HttpStatus.CONFLICT);
    }
}