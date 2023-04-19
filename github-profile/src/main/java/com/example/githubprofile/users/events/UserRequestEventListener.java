package com.example.githubprofile.users.events;

import com.example.githubprofile.users.persistence.RequestRegistry;
import com.example.githubprofile.users.persistence.RequestRegistryRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
public class UserRequestEventListener implements ApplicationListener<UserRequestEvent> {
    private static final Logger LOGGER = LogManager.getLogger(UserRequestEventListener.class);
    private final static Integer INITIAL_VALUE = 1;
    private final RequestRegistryRepository registryRepository;

    public UserRequestEventListener(RequestRegistryRepository registryRepository) {
        this.registryRepository = registryRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(UserRequestEvent event) {
        String login = event.getMessage();
        LOGGER.info("[USER_EVENT] Handle UserRequestEvent with value {}", login);

        Optional<RequestRegistry> byId = registryRepository.findById(login);
        if (byId.isPresent()) {
            registryRepository.registerQuery(login);
            LOGGER.info("[USER_EVENT] Request count has been updated");
        } else {
            RequestRegistry newRegistry = new RequestRegistry(login, INITIAL_VALUE);
            registryRepository.save(newRegistry);
            LOGGER.info("[USER_EVENT] Create new entry for login {}", login);
        }
    }
}
