package com.example.githubprofile.users.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

@Component
public class ExternalServicesErrorHandler implements ResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return response.getStatusCode().is4xxClientError() || response.getStatusCode().is5xxServerError();
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        if (response.getStatusCode().is5xxServerError()) {
            throw new ExternalServiceServerError("[SERVER ERROR]: " + response);
        }

        if (response.getStatusCode().is4xxClientError()) {
            if (response.getStatusCode().value() == HttpStatus.NOT_FOUND.value()) {
                throw new ExternalServiceNotFoundException("[EXTERNAL SERVICE] User in external service not found: " + response.getBody());
            }
            throw new RuntimeException("[CLIENT ERROR] Unpredicted error code has been returned");
        }

        throw new RuntimeException("[ERROR] Unpredicted error code has been returned: " + response.getBody());
    }
}
