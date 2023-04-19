package com.example.githubprofile.users.externalservices;

import com.example.githubprofile.users.dto.GitHubUser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

@Service
public class GithubService implements UserExternalServices<GitHubUser> {
    private static final Logger LOGGER = LogManager.getLogger(GithubService.class);
    private final RestTemplate restTemplate;

    @Value("${external.service.github.template}")
    private String requestPath;

    public GithubService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public GitHubUser getUserBy(String login) {
        var uri = new UriTemplate(requestPath).expand(login);
        var requestEntity = new RequestEntity<GitHubUser>(HttpMethod.GET, uri);

        LOGGER.info("[GITHUB SERVICE] Call service {}", requestEntity);
        return restTemplate.exchange(requestEntity, GitHubUser.class).getBody();
    }
}
