package com.example.githubprofile.users.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "request_registry")
public class RequestRegistry {

    @Id
    @NotNull
    @Column(name = "login", nullable = false)
    private String login;

    @Column(name = "request_count", nullable = false)
    private Integer requestCount;

    protected RequestRegistry() {
    }

    public RequestRegistry(String login, Integer requestCount) {
        this.login = login;
        this.requestCount = requestCount;
    }

    public String getLogin() {
        return login;
    }

    public Integer getRequestCount() {
        return requestCount;
    }
}
