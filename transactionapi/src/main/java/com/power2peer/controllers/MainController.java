package com.power2peer.controllers;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.power2peer.models.EnergyTransaction;
import com.power2peer.models.NewUser;
import com.power2peer.models.RegisteredUser;
import com.power2peer.services.UserRegistry;

@CrossOrigin
@RestController
public class MainController {

	private UserRegistry userRegistry;

	@Autowired
	public MainController(UserRegistry userRegistry) {
		this.userRegistry = userRegistry;
	}

	@RequestMapping("/transactions")
	public Collection<EnergyTransaction> fetchAllTransactions() {
		return Collections.emptyList();
	}

	@PostMapping("/registerusers")
	public List<RegisteredUser> registerUsers(@RequestBody List<NewUser> request) {
		List<RegisteredUser> user = userRegistry.registerUsers(request);
		return user;
	}

	@PostMapping("/registeruser")
	public RegisteredUser registerUser(@RequestBody NewUser request) {
		RegisteredUser user = userRegistry.register(request);
		return user;
	}

	@RequestMapping("/user/{name}")
	public RegisteredUser fetchUser(@PathVariable String name) {
		return userRegistry.getUser(name);
	}

}
