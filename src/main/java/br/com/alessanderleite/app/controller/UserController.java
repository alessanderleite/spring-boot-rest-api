package br.com.alessanderleite.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alessanderleite.app.dto.UserDto;
import br.com.alessanderleite.app.model.User;
import br.com.alessanderleite.app.response.Response;
import br.com.alessanderleite.app.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping
	public ResponseEntity<Response<UserDto>> create(@Valid @RequestBody UserDto dto, BindingResult result) {
		
		Response<UserDto> response = new Response<>();
		User user = service.save(this.convertDtoToEntity(dto));
		response.setData(this.convertEntityToDto(user));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	private User convertDtoToEntity(UserDto dto) {
		User u = new User();
		u.setName(dto.getName());
		u.setPassword(dto.getPassword());
		u.setEmail(dto.getEmail());
		
		return u;
	}
	
	private UserDto convertEntityToDto(User u) {
		UserDto dto = new UserDto();
		dto.setName(u.getName());
		dto.setPassword(u.getPassword());
		dto.setEmail(u.getEmail());
		
		return dto;
	}
}
