package org.my.petwaale.authservice.dto;

public class UserDTO 
{
	private long id;
	private String name;
	private String password;
	
	
	//Getter and Setter Methods
	public long getId() 
	{
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
