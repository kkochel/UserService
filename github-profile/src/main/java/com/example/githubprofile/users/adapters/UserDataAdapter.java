package com.example.githubprofile.users.adapters;

import com.example.githubprofile.users.dto.UserData;

public interface UserDataAdapter <T> {
    UserData getUserDataFrom(T externalDto);
}
