package br.com.alessanderleite.app.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class UserDto {

	private Long id;
	
	@NotNull
	@Length(min = 6, message = "Your password must be at least 6 characters")
	private String password;
	
	@Length(min = 5, max = 50, message = "Your name must be between 5 and 50 characters")
	private String name;
	
	@Email(message = "Invalid email address")
	private String email;
	
	public UserDto() {}

	public UserDto(@NotNull @Length(min = 6, message = "Your password must be at least 6 characters") String password,
			@Length(min = 5, max = 50, message = "Your name must be between 5 and 50 characters") String name,
			@Email(message = "Invalid email address") String email) {
		this.password = password;
		this.name = name;
		this.email = email;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "UserDto [id=" + id + ", password=" + password + ", name=" + name + ", email=" + email + "]";
	}
}
