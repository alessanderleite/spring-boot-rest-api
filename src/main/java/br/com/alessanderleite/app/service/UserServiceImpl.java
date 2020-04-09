package br.com.alessanderleite.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alessanderleite.app.model.User;
import br.com.alessanderleite.app.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User save(User u) {
		return userRepository.save(u);
	}

	@Override
	public Optional<User> findByEmail(String email) {
		return userRepository.findByEmailEquals(email);
	}
}
