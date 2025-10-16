package org.my.petwaale.forgot_password.controller;


import lombok.RequiredArgsConstructor;

import org.my.petwaale.forgot_password.dto.ApiResponse;
import org.my.petwaale.forgot_password.dto.ForgotPasswordRequest;
import org.my.petwaale.forgot_password.dto.ResetPasswordRequest;
import org.my.petwaale.forgot_password.service.ForgotPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth/forgot-password")
@RequiredArgsConstructor
public class ForgotPasswordController 
{

	@Autowired
    private ForgotPasswordService service;

    @PostMapping("/request")
    public ResponseEntity<ApiResponse> requestReset(@Valid @RequestBody ForgotPasswordRequest request) {
        service.requestPasswordReset(request);
        return ResponseEntity.ok(new ApiResponse("Password reset link sent to your email."));
    }

    @PostMapping("/reset")
    public ResponseEntity<ApiResponse> resetPassword(@Valid @RequestBody ResetPasswordRequest request) {
        service.resetPassword(request);
        return ResponseEntity.ok(new ApiResponse("Password reset successful."));
    }
}

