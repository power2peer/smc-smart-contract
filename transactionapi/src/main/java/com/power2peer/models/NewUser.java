package com.power2peer.models;

import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

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
	@Setter
	@Getter
	@JsonProperty("location")
	private GeoJsonPoint location = new GeoJsonPoint(0, 0);

	/**
	 * Ethereum Address.
	 */
	@Getter
	@Setter
	@JsonProperty("ethAddress")
	private String ethAddress;

	/**
	 * Usertype.
	 */
	@Getter
	@Setter
	@JsonProperty("type")
	private UserType type;

	/**
	 * PricePerKWh.
	 */
	@Getter
	@Setter
	@JsonProperty("pricePerKwh")
	private float pricePerKwh;

}
