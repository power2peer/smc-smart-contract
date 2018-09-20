package com.power2peer.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class NewUser {

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
	

}
