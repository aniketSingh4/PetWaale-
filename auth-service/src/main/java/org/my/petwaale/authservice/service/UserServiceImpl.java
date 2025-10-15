package org.my.petwaale.authservice.service;


import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.my.petwaale.authservice.dto.UserDTO;
import org.my.petwaale.authservice.model.User;
import org.my.petwaale.authservice.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService 
{
	 @Autowired
	 private UsersRepository userRepository;
	
	 @Autowired
	 private PasswordEncoder passwordEncoder;
	 
	
	 @Override
	 public User registerNewUser(String username, String password) throws Exception 
	 {
	     Optional<User> existing = userRepository.findByUsername(username);
	     if (existing.isPresent()) {
	         throw new Exception("Username already exists");
	     }
	     String encodedPwd = passwordEncoder.encode(password);
	     User user = new User(username, encodedPwd);
	     return userRepository.save(user);
	 }
	
	 @Override
	 public User findByUsername(String username) 
	 {
	     return 
	    		 userRepository
	    		 	.findByUsername(username)
	    		 	.orElseThrow(()-> new RuntimeException("No such Used Found!."));
	 }
	
	 @Override
	 public User registerNewUser(UserDTO userDTO) throws Exception 
	 {
		String userName = userDTO.getName();
		String password = userDTO.getPassword();

		Optional<User> existing = userRepository.findByUsername(userName);
	     if (existing.isPresent()) {
	         throw new Exception("Username already exists");
	     }
	     String encodedPwd = passwordEncoder.encode(password);
	     User user = new User(userName, encodedPwd);
	     return userRepository.save(user);
		
	 }
	
	 

}

