package org.my.petwaale.forgot_password.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "password-reset-tokens")
public class PasswordResetToken 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    @Column(unique = true, nullable = false)
    private String token;

    private LocalDateTime expiry;

    private boolean used = false;

    
    //Getter and Setter Method
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public LocalDateTime getExpiry() {
		return expiry;
	}

	public void setExpiry(LocalDateTime expiry) {
		this.expiry = expiry;
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}

	
	//No-Arg Constructor and All-Arg Constructor
	public PasswordResetToken(Long id, Long userId, String token, LocalDateTime expiry, boolean used) 
	{
		super();
		this.id = id;
		this.userId = userId;
		this.token = token;
		this.expiry = expiry;
		this.used = used;
	}

	public PasswordResetToken() 
	{
		super();
		// TODO Auto-generated constructor stub
	}

	
	//Builder Implementation
	public static Builder builder() 
	{
        return new Builder();
    }

    public static class Builder 
    {
        private Long id;
        private Long userId;
        private String token;
        private LocalDateTime expiry;
        private boolean used;

        public Builder id(Long id) 
        {
            this.id = id;
            return this;
        }

        public Builder userId(Long userId) {
            this.userId = userId;
            return this;
        }

        public Builder token(String token) {
            this.token = token;
            return this;
        }

        public Builder expiry(LocalDateTime expiry) {
            this.expiry = expiry;
            return this;
        }

        public Builder used(boolean used) {
            this.used = used;
            return this;
        }

        public PasswordResetToken build() {
            return new PasswordResetToken(id, userId, token, expiry, used);
        }
    }
	

}

