package com.power2peer.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

import com.power2peer.models.EnergyTransaction;
import com.power2peer.models.RegisteredUser;
import com.power2peer.models.RegisteredUserRepository;

@RestController
@RequestMapping(path = "/transactions")
public class TransactionController {
	@Autowired
	RegisteredUserRepository registeredUserRepository;

	@PostMapping(path = "/sell/{producerid}/{consumerid}")
	public TransactionReceipt tx(@PathVariable("producerid") String producerid,
			@PathVariable("consumerid") String consumerid, @RequestBody String body) {

		// body should contain number of units to transfer
		int units = Integer.parseInt(body);

		Optional<RegisteredUser> user = registeredUserRepository.findById(producerid);
		RegisteredUser theUser = user.orElseThrow(() -> {
			return new RuntimeException();
		});

		Optional<RegisteredUser> user2 = registeredUserRepository.findById(consumerid);
		RegisteredUser theUser2 = user2.orElseThrow(() -> {
			return new RuntimeException();
		});

		return new EnergyTransaction(theUser).sellTo(theUser2, units);
	}

}
