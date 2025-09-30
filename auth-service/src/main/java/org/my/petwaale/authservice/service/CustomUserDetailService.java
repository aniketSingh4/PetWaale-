package org.my.petwaale.authservice.service;

import java.util.Collections;

import org.my.petwaale.authservice.model.Users;
import org.my.petwaale.authservice.repository.UsersRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    private final UsersRepository repo;

    public CustomUserDetailService(UsersRepository repo) 
    {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
    {
        Users user = repo.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        
        
        return new User(
            user.getUsername(),
            user.getPassword(),
            Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))
        );
    }
}
