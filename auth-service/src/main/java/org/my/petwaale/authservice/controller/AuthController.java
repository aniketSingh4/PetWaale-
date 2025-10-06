package org.my.petwaale.authservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/auth")
public class AuthController 
{
	@GetMapping("/signup")
	public String signUp()
	{
		return "signup";
	}
	
	@GetMapping("/login")
	public String login()
	{
		return "login";
	}

}
