package com.power2peer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UIController {

	@GetMapping(value = "/users")
	public String users() {
		return "users";
	}
}
