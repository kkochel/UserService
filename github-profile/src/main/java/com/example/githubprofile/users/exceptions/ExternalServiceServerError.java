package com.example.githubprofile.users.exceptions;

public class ExternalServiceServerError extends RuntimeException {
    public ExternalServiceServerError(String message) {
        super(message);
    }
}
