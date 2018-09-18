package com.power2peer.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class RegisteredUser {

	@Getter
	@Setter
	@JsonProperty("name")
	private String name;

	@Getter
	@Setter
	@JsonProperty("email")
	private String emailAddress;

	@Getter
	@Setter
	@JsonProperty("mac")
	private String macAddress;

	public RegisteredUser(NewUser request) {
		this.emailAddress = request.getEmailAddress();
		this.name = request.getName();
		this.macAddress = request.getMacAddress();
	}

}
