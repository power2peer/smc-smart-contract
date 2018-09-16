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

}
