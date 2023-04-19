package com.example.githubprofile.users.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RequestRegistryRepository extends JpaRepository<RequestRegistry, String> {

    @Modifying
    @Query(value = "UPDATE RequestRegistry r SET r.requestCount=(r.requestCount +1 ) WHERE r.login =:login")
    void registerQuery(@Param("login") String login);
}
