package com.example.githubprofile.users;

import com.example.githubprofile.users.adapters.UserDataAdapter;
import com.example.githubprofile.users.dto.GitHubUser;
import com.example.githubprofile.users.dto.UserData;
import com.example.githubprofile.users.events.UserRequestEvent;
import com.example.githubprofile.users.externalservices.UserExternalServices;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private static final Logger LOGGER = LogManager.getLogger(UserService.class);
    private final UserExternalServices<GitHubUser> githubService;
    private final UserDataAdapter<GitHubUser> gitHubUserUserDataAdapter;
    private final ApplicationEventPublisher eventPublisher;

    public UserService(UserExternalServices<GitHubUser> githubService, UserDataAdapter<GitHubUser> gitHubUserUserDataAdapter, ApplicationEventPublisher eventPublisher) {
        this.githubService = githubService;
        this.gitHubUserUserDataAdapter = gitHubUserUserDataAdapter;
        this.eventPublisher = eventPublisher;
    }


    public UserData getUserData(String login) {
        eventPublisher.publishEvent(new UserRequestEvent(this, login));
        LOGGER.info("[USER_EVENT] Published event UserRequestEvent with value {}", login);

        return gitHubUserUserDataAdapter.getUserDataFrom(githubService.getUserBy(login));
    }

}
