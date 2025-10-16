package org.my.petwaale.authservice.forgot_password.dto;

import lombok.AllArgsConstructor;
import lombok.Data;


public class ApiResponse 
{
    private String message;

    
    //Getter and Setter Methods
    public String getMessage() 
    {
		return message;
	}

	public void setMessage(String message) 
	{
		this.message = message;
	}

	public ApiResponse(String message) {
		super();
		this.message = message;
	}

	public ApiResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	
}