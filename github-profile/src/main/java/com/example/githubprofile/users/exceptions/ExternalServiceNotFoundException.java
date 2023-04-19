package com.example.githubprofile.users.exceptions;

public class ExternalServiceNotFoundException extends RuntimeException {
    public ExternalServiceNotFoundException(String message) {
        super(message);
    }
}
