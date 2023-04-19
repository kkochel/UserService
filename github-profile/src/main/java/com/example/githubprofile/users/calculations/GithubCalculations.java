package com.example.githubprofile.users.calculations;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class GithubCalculations implements UserCalculations {
    private static final Logger LOGGER = LogManager.getLogger(GithubCalculations.class);

    @Override
    public Double calculation(Integer numberOfFollowers, Integer numberOfPublicRepositories) {
        if (numberOfFollowers <= 0) {
            LOGGER.warn("[CALCULATIONS] Invalid number of followers {} ", numberOfFollowers);
            return Double.valueOf(0);
        }

        return 6D / numberOfFollowers * (2 + numberOfPublicRepositories);
    }
}
