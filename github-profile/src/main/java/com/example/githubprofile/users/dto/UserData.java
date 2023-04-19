package com.example.githubprofile.users.dto;

import java.time.LocalDateTime;

public record UserData(String id,
                       String login,
                       String name,
                       String type,
                       String avatarUrl,
                       LocalDateTime createdAt,
                       Number calculations) { }
