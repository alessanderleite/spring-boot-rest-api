package br.com.alessanderleite.app.service;

import java.util.Optional;

import br.com.alessanderleite.app.model.User;

public interface UserService {

	User save(User u);
	Optional<User> findByEmail(String email);
}
