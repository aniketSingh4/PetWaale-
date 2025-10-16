package org.my.petwaale.authservice.forgot_password.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ForgotPasswordRequest 
{
    @NotBlank
    private String username;

    
    //Getter and Setter Methods
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public ForgotPasswordRequest(@NotBlank String username) {
		super();
		this.username = username;
	}
	
	
    
}

