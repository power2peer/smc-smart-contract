package com.power2peer.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.power2peer.models.NewUser;
import com.power2peer.models.RegisteredUser;

public class UserRegistry {

	private static Map<String, RegisteredUser> users = new HashMap<>();

	public static RegisteredUser register(NewUser request) {
		if (users.containsKey(request.getName())) {
			throw new RuntimeException("User already exists!");
		}
		users.put(request.getName(), new RegisteredUser(request.getName()));
		return users.get(request.getName());
	}

	public static RegisteredUser getUser(String username) {
		return users.get(username);
	}

	public static List<RegisteredUser> allUsers() {
		return new ArrayList<>(users.values());
	}

}
