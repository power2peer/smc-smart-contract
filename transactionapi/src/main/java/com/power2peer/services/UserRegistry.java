package com.power2peer.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.power2peer.models.NewUser;
import com.power2peer.models.RegisteredUser;
import com.power2peer.models.RegisteredUserRepository;

@Service
public class UserRegistry {

	private final RegisteredUserRepository registeredUserRepository;

	public UserRegistry(RegisteredUserRepository registeredUserRepository) {
		this.registeredUserRepository = registeredUserRepository;
	}

	public RegisteredUser register(NewUser request) {
		return registeredUserRepository.save(new RegisteredUser(request));
	}

	public RegisteredUser getUser(String username) {
		return registeredUserRepository.findByName(username);
	}

	public List<RegisteredUser> allUsers() {
		return registeredUserRepository.findAll();
	}

	public List<RegisteredUser> registerUsers(List<NewUser> request) {
		return registeredUserRepository.saveAll(request.stream().map(item -> {
			return new RegisteredUser(item);
		}).collect(Collectors.toList()));
	}

	public List<RegisteredUser> findAll() {
		return registeredUserRepository.findAll();
	}

}
