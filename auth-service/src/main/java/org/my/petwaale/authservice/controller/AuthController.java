package org.my.petwaale.authservice.controller;


import java.util.List;

import org.my.petwaale.authservice.forgot_password.ForgotPasswordClient;
import org.my.petwaale.authservice.forgot_password.dto.ApiResponse;
import org.my.petwaale.authservice.forgot_password.dto.ForgotPasswordRequest;
import org.my.petwaale.authservice.model.Product;
import org.my.petwaale.authservice.service.ProductService;
import org.my.petwaale.authservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/api/auth/")
public class AuthController 
{
	@Autowired
	private UserService userService;
	
	@Autowired
	private ForgotPasswordClient forgotPasswordClient;

	@GetMapping("signup")
	public String signupForm() 
	{
		return "signup";
	}

	@PostMapping("signup")
	public String signupSubmit(@RequestParam String username,
                            @RequestParam String password,
                            Model model) 
	{
		try {
			userService.registerNewUser(username, password);
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			return "signup";
		}
		return "redirect:/api/auth/login";
	}

	@GetMapping("login")
	public String loginForm() 
	{
		return "login";
	}

	@GetMapping("welcome")
	public String welcomePage(Model model, 
			org.springframework.security.core.Authentication authentication) 
	{
		// you can get the username
		String username = authentication.getName();
		model.addAttribute("username", username);
		return "welcome";
	}
	
	//shopping 
	@GetMapping("shop")
	public String shopPage(Model model) 
	{
	    List<Product> products = ProductService.getAllProducts();
	    model.addAttribute("shopItems", products);
	    return "shop";
	}
	
	@PostMapping("forgot-password")
    public ResponseEntity<ApiResponse> forgotPassword(@Valid @RequestBody ForgotPasswordRequest request) 
	{
        forgotPasswordClient.callForgotPasswordService(request);
        return ResponseEntity.ok(new ApiResponse("Password reset request sent successfully."));
    }
}

