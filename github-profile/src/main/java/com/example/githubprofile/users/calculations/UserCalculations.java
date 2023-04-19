package com.example.githubprofile.users.calculations;

import jakarta.validation.constraints.NotNull;

public interface UserCalculations {

    Double calculation(@NotNull Integer numberOfFollowers, @NotNull Integer numberOfPublicRepositories);
}
