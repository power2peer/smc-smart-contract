package com.power2peer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UIController {

	@RequestMapping("/")
	public String index() {
		return users();
	}
	
	@GetMapping(value = "/users")
	public String users() {
		return "users";
	}
}
