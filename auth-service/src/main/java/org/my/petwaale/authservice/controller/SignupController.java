package org.my.petwaale.authservice.controller;

import org.my.petwaale.authservice.dto.UserDTO;
import org.my.petwaale.authservice.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.ui.Model;   // ✅ correct



@Controller
@RequestMapping("/api")
public class SignupController {

    private final UserService userService;

    public SignupController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/signup")
    public String signupForm() {
        return "signup";
    }

    @PostMapping("/signup")
    public String processSignup(@RequestParam String username,
            @RequestParam String password,
            Model model) throws Exception 
    {
    	 try {
    	         userService.registerNewUser(username, password);
    	     } catch (Exception e) 
    	 {
    	         model.addAttribute("error", e.getMessage());
    	         return "signup";
    	     }
    	     return "redirect:/login";
    }
    

}

