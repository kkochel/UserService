package com.example.githubprofile.users;

import com.example.githubprofile.users.exceptions.ExternalServicesErrorHandler;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Configuration
public class UserConfiguration {

    @Bean
    RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder
                .setConnectTimeout(Duration.of(3, ChronoUnit.SECONDS))
                .setReadTimeout(Duration.of(3, ChronoUnit.SECONDS))
                .errorHandler(new ExternalServicesErrorHandler())
                .build();
    }

}
