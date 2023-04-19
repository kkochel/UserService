package com.example.githubprofile.users.externalservices;

public interface UserExternalServices<T> {

    T getUserBy(String login);
}
