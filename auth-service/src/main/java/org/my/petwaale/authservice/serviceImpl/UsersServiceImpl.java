package org.my.petwaale.authservice.serviceImpl;

import java.util.List;

import org.my.petwaale.authservice.model.Users;
import org.my.petwaale.authservice.repository.UsersRepository;
import org.my.petwaale.authservice.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService
{
	@Autowired
	private UsersRepository repo;

	@Override
	public Users addUsers(Users users) 
	{
		repo.save(users);
		return users;
	}

	@Override
	public Users getUsersById(Long id) 
	{
		
		return repo.findById(id).orElseThrow(()-> new RuntimeException("No such Users Found!"));
	}

	@Override
	public List<Users> getUsers() 
	{
		return repo.findAll();
	}

	@Override
	public Users updateUsers(Users users) 
	{
		long id = users.getId();
		Users newUser = repo.findById(id).orElseThrow(()-> new RuntimeException("No such Users Found!"));
		repo.save(newUser);
		return newUser;
	}

	@Override
	public Users updateUsersById(Long id) 
	{
		Users newUser = repo.findById(id).orElseThrow(()-> new RuntimeException("No such Users Found!"));
		repo.save(newUser);
		return newUser;
	}

	@Override
	public Users deleteUsers(Users users) 
	{
		repo.delete(users);
		return users;
	}

	@Override
	public Users deleteUsersById(Long id) 
	{
		Users newUser = repo.findById(id).orElseThrow(()-> new RuntimeException("No such Users Found!"));
		repo.deleteById(id);
		return newUser;
	}

}
