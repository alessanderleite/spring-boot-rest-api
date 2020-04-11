package br.com.alessanderleite.app.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.alessanderleite.app.dto.UserDto;
import br.com.alessanderleite.app.model.User;

@Component
public class UserConverter {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public User convertDtoToEntity(UserDto dto) {
		User u = modelMapper.map(dto, User.class);
		return u;
	}
	
	public UserDto convertEntityToDto(User u) {
		UserDto dto = modelMapper.map(u, UserDto.class);
		return dto;
	}
}
