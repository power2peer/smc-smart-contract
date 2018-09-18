package com.power2peer.controllers;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.power2peer.models.EnergyTransaction;
import com.power2peer.models.NewUser;
import com.power2peer.models.RegisteredUser;
import com.power2peer.services.UserRegistry;

@RestController
public class TransactionController {

	private Map<String, EnergyTransaction> transactions = new HashMap<>();

	public TransactionController() {
		this.transactions.put("id1", new EnergyTransaction("producer1"));
		this.transactions.put("id2", new EnergyTransaction("producer2"));
	}

	@RequestMapping("/transactions")
	public Collection<EnergyTransaction> fetchAllTransactions() {
		return transactions.values();
	}

	@RequestMapping("/transaction/{name}")
	public EnergyTransaction fetchTransaction(@PathVariable("name") String name) {
		return transactions.get(name);
	}

	@PostMapping("/registerusers")
	public List<RegisteredUser> registerUsers(@RequestBody List<NewUser> request) {
		List<RegisteredUser> user = UserRegistry.registerUsers(request);
		return user;
	}

	@PostMapping("/registeruser")
	public RegisteredUser registerUser(@RequestBody NewUser request) {
		RegisteredUser user = UserRegistry.register(request);
		return user;
	}

	@RequestMapping("/user/{username}")
	public RegisteredUser fetchUser(@PathVariable String username) {
		RegisteredUser user = UserRegistry.getUser(username);
		return user;
	}

	@RequestMapping("/users")
	public List<RegisteredUser> fetchUsers() {
		return UserRegistry.allUsers();
	}

}
