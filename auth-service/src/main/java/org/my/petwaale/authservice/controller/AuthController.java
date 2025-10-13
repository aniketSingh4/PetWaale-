package org.my.petwaale.authservice.controller;


import org.my.petwaale.authservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/")
public class AuthController 
{
 @Autowired
 private UserService userService;

// @GetMapping("signup")
// public String signupForm() {
//     return "signup";
// }
//
// @PostMapping("signup")
// public String signupSubmit(@RequestParam String username,
//                            @RequestParam String password,
//                            Model model) 
// {
//     try {
//         userService.registerNewUser(username, password);
//     } catch (Exception e) {
//         model.addAttribute("error", e.getMessage());
//         return "signup";
//     }
//     return "redirect:/login";
// }

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
}

