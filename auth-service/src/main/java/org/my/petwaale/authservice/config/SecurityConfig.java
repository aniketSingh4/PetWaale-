package org.my.petwaale.authservice.config;


import org.my.petwaale.authservice.model.User;
import org.my.petwaale.authservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {

 @Autowired
 private UserService userService;

 @Bean
 public UserDetailsService userDetailsService() 
 {
     return username -> {
         User user = userService.findByUsername(username);
         if (user == null) {
             throw new UsernameNotFoundException("User not found");
         }
         // Here, authorities / roles are empty (no roles). You can add roles later.
         return org.springframework.security.core.userdetails.User
                 .withUsername(user.getUsername())
                 .password(user.getPassword())
                 .authorities("USER")  // default authority
                 .build();
     };
 }


@Bean
 public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception 
{
     http
         .csrf().disable()  // disable CSRF for simplicity (not recommended for production) 
         .authorizeHttpRequests(authorize -> authorize
             .requestMatchers("/signup", "/login", "/css/**", "/js/**").permitAll()
             .anyRequest().authenticated()
         )
         .formLogin(form -> form
             .loginPage("/login")
             .defaultSuccessUrl("/welcome", true)
             .permitAll()
         )
         .logout(logout -> logout
             .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
             .logoutSuccessUrl("/login?logout")
             .permitAll()
         );
     return http.build();
 }
}

