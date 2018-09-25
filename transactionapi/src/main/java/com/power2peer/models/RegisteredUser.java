package com.power2peer.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import org.springframework.data.annotation.Id;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RegisteredUser {

	@Id
	@Getter
	@JsonProperty("id")
	public String id;

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

	@Getter
	@Setter
	@JsonProperty("ip")
	private String ip;

	@Getter
	@Setter
	@JsonProperty("location")
	private String location;

	/**
	 * Ethereum Address.
	 */
	@Getter
	@Setter
	@JsonProperty("ethAddress")
	private String ethAddress = "";
	
	
	@Getter
	@Setter
	@JsonProperty("tokensAvailable")
	private int tokensAvailable = 0;

	public RegisteredUser(NewUser request) {
		this.emailAddress = request.getEmailAddress();
		this.name = request.getName();
		this.macAddress = request.getMacAddress();
		this.ip = request.getIp();
		this.location = request.getLocation();
		this.ethAddress = request.getEthAddress();
	}

}
