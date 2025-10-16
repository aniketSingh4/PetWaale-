package org.my.petwaale.authservice.forgot_password;



import org.my.petwaale.authservice.forgot_password.dto.ForgotPasswordRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ForgotPasswordClient 
{

	@Autowired
    private WebClient.Builder webClientBuilder;

    @Value("${forgot.password.service.url}")
    private String forgotPasswordServiceUrl; // e.g. http://localhost:8082

    public void callForgotPasswordService(ForgotPasswordRequest request) 
    {
        webClientBuilder.build()
                .post()
                .uri(forgotPasswordServiceUrl + "/api/auth/forgot-password")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(Void.class)
                .block(); // waits for response synchronously
    }
}

