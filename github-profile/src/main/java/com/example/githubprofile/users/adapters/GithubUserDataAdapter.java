package com.example.githubprofile.users.adapters;

import com.example.githubprofile.users.dto.GitHubUser;
import com.example.githubprofile.users.dto.UserData;
import com.example.githubprofile.users.calculations.UserCalculations;
import org.springframework.stereotype.Component;

@Component
public class GithubUserDataAdapter implements UserDataAdapter<GitHubUser> {

    private final UserCalculations githubCalculations;

    public GithubUserDataAdapter(UserCalculations githubCalculations) {
        this.githubCalculations = githubCalculations;
    }

    @Override
    public UserData getUserDataFrom(GitHubUser externalDto) {
        Double calculation = githubCalculations.calculation(externalDto.followers(), externalDto.public_repos());

        return new UserData(
                externalDto.id(),
                externalDto.login(),
                externalDto.name(),
                externalDto.type(),
                externalDto.avatar_url(),
                externalDto.created_at(),
                calculation);
    }
}
