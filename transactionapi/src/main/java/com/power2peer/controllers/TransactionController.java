package com.power2peer.controllers;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.power2peer.models.EnergyTransaction;

@RestController
public class TransactionController {

	private Map<String, EnergyTransaction> transactions = new HashMap<>();

	public TransactionController() {
		this.transactions.put("id1", new EnergyTransaction("producer1"));
		this.transactions.put("id2", new EnergyTransaction("producer2"));
	}

	@RequestMapping("/transactions")
	public Collection<EnergyTransaction> fetchAllTransactions() {
		return transactions.values();
	}

	@RequestMapping("/transaction/{name}")
	public EnergyTransaction fetchTransaction(@PathVariable("name") String name) {
		return transactions.get(name);
	}

}
