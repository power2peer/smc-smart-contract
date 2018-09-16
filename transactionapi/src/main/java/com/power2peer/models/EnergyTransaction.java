package com.power2peer.models;

import lombok.Getter;

public class EnergyTransaction {

	@Getter
	private final String producer;

	public EnergyTransaction(String producer) {
		this.producer = producer;
	}

}
