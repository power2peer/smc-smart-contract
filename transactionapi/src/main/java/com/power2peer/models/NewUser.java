package com.power2peer.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
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

	@Builder.Default
	@Getter
	@Setter
	@JsonProperty("mac")
	private String macAddress = "";

	@Builder.Default
	@Getter
	@Setter
	@JsonProperty("ip")
	private String ip = "";

	@Builder.Default
	@Getter
	@Setter
	@JsonProperty("location")
	private String location = "";

	/**
	 * Ethereum Address.
	 */
	@Getter
	@Setter
	@JsonProperty("ethAddress")
	private String ethAddress;

}
