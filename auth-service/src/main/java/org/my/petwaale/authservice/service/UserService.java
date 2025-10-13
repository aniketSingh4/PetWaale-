package org.my.petwaale.authservice.service;

import org.my.petwaale.authservice.dto.UserDTO;
import org.my.petwaale.authservice.model.User;

public interface UserService 
{
    User registerNewUser(String username, String password) throws Exception;
    User findByUsername(String username);
    User registerNewUser(UserDTO userDTO) throws Exception;
}