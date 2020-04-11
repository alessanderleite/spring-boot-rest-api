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
import br.com.alessanderleite.app.util.UserConverter;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@Autowired
	private UserConverter converter;

	@PostMapping
	public ResponseEntity<Response<UserDto>> create(@Valid @RequestBody UserDto dto, BindingResult result) {
		Response<UserDto> response = new Response<>();
		User user = service.save(converter.convertDtoToEntity(dto));
		response.setData(converter.convertEntityToDto(user));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
}
