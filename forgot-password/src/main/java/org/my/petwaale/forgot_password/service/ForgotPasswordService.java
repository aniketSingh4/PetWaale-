package org.my.petwaale.forgot_password.service;


import lombok.RequiredArgsConstructor;

import org.my.petwaale.forgot_password.dto.ForgotPasswordRequest;
import org.my.petwaale.forgot_password.dto.ResetPasswordRequest;
import org.my.petwaale.forgot_password.model.PasswordResetToken;
import org.my.petwaale.forgot_password.repository.PasswordResetTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ForgotPasswordService 
{

	@Autowired
    private PasswordResetTokenRepository tokenRepository;
	
	@Autowired
    private EmailService emailService;
	
	@Autowired
    private AuthClient authClient;

    public void requestPasswordReset(ForgotPasswordRequest request) 
    {
        // TODO: Replace with actual call to Auth-Service to fetch user details
        Long userId = 1L;
        String userEmail = request.getUsername() + "@example.com";

        String token = UUID.randomUUID().toString();
        PasswordResetToken resetToken = PasswordResetToken.builder()
                .userId(userId)
                .token(token)
                .expiry(LocalDateTime.now().plusMinutes(15))
                .build();
        
        tokenRepository.save(resetToken);

        emailService.sendResetEmail(userEmail, token);
    }

    public void resetPassword(ResetPasswordRequest request) 
    {
        PasswordResetToken token = tokenRepository.findByToken(request.getToken())
                .orElseThrow(() -> new RuntimeException("Invalid token"));

        if (token.isUsed() || token.getExpiry().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Token expired or already used");
        }

        authClient.updatePassword(token.getUserId(), request.getNewPassword());
        token.setUsed(true);
        tokenRepository.save(token);
    }
}

