package com.example.githubprofile.users.dto;

import java.time.LocalDateTime;

public record GitHubUser(String id,
                         String login,
                         String name,
                         String type,
                         String avatar_url,
                         Integer public_repos,
                         Integer followers,
                         LocalDateTime created_at) { }
