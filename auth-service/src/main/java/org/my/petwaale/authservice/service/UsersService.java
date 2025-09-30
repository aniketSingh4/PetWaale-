package org.my.petwaale.authservice.service;

import java.util.List;

import org.my.petwaale.authservice.model.Users;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersService 
{
	Users addUsers(Users users);
	Users getUsersById(Long id);
	List<Users> getUsers();
	Users updateUsers(Users users);
	Users updateUsersById(Long id);
	Users deleteUsers(Users users);
	Users deleteUsersById(Long id);

}
