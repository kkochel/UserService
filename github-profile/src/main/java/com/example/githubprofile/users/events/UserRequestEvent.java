package com.example.githubprofile.users.events;

import org.springframework.context.ApplicationEvent;

public class UserRequestEvent extends ApplicationEvent {
    private final String message;

    public UserRequestEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

