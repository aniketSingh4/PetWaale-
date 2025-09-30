package org.my.petwaale.authservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class UserSecurityConfig 
{
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception
	{
		httpSecurity
			.authorizeHttpRequests(request -> request.requestMatchers("/login", "/register", "/css/**", "/js/**").permitAll()
				.anyRequest().authenticated())
			
			.formLogin(form -> form
	                .loginPage("/login")
	                .defaultSuccessUrl("/dashboard", true)
	                .permitAll())
			
			.logout(logout -> logout
	                .logoutSuccessUrl("/login?logout")
	                .permitAll()
	            );
		
		return httpSecurity.build();
		
	}
	
	@Bean
    public BCryptPasswordEncoder passwordEncoder() 
	{
        return new BCryptPasswordEncoder();
    }

}
