package org.my.petwaale.forgot_password.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class AuthClient 
{

    private final WebClient webClient;

    public AuthClient(@Value("${auth.service.url}") String authServiceUrl) {
        this.webClient = WebClient.builder().baseUrl(authServiceUrl).build();
    }

    public void updatePassword(Long userId, String newPassword) {
        webClient.post()
                .uri("/internal/update-password")
                .bodyValue(new PasswordUpdateRequest(userId, newPassword))
                .retrieve()
                .toBodilessEntity()
                .block();
    }

    private record PasswordUpdateRequest(Long userId, String newPassword) {}
}

