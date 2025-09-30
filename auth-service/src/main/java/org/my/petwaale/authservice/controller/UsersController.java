package org.my.petwaale.authservice.controller;

import java.util.List;

import org.my.petwaale.authservice.model.Users;
import org.my.petwaale.authservice.serviceImpl.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/auth")
public class UsersController 
{
	@Autowired
	private UsersServiceImpl userSer;
	
	@GetMapping()
	public List<Users> getAllUsers()
	{
		return userSer.getUsers();
	}
	
	@GetMapping("/{id}")
	public Users getUserById(@PathVariable long id)
	{
		return userSer.getUsersById(id);
	}
	
	@PostMapping()
	public Users addUsers(@RequestBody Users user)
	{
		return userSer.addUsers(user);
	}
	
	@PutMapping()
	public Users updateUsers(@RequestBody Users user)
	{
		return userSer.updateUsers(user);
	}
	
	@PutMapping("/{id}")
	public Users updateUsersById(@PathVariable long id)
	{
		return userSer.updateUsersById(id);
	}
	
	@DeleteMapping()
	public Users deleteUsers(@RequestBody Users user)
	{
		return userSer.deleteUsers(user);
	}
	
	@DeleteMapping("/{id}")
	public Users deleteUsersById(@PathVariable long id)
	{
		return userSer.deleteUsersById(id);
	}
	
	
	
	@GetMapping("/login")
    public String login() 
	{
        return "login";
    }

    @GetMapping("/dashboard")
    public String dashboard() 
    {
        return "dashboard";
    }
	
	

}
