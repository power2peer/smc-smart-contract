package com.power2peer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.power2peer.models.NewUser;
import com.power2peer.models.RegisteredUser;
import com.power2peer.models.RegisteredUserRepository;

@SpringBootApplication
public class TransactionapiApplication implements CommandLineRunner {

	@Autowired
	public RegisteredUserRepository registeredUserRepository;

	public static void main(String[] args) {
		SpringApplication.run(TransactionapiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		registeredUserRepository.deleteAll();

		NewUser newUser = NewUser.builder().name("Binod").emailAddress("binod@new.com").build();
		NewUser newUser2 = NewUser.builder().name("Nish").emailAddress("nish@new.com").build();
		NewUser newUser3 = NewUser.builder().name("Eric").emailAddress("eric@new.com").build();

		registeredUserRepository.save(new RegisteredUser(newUser));
		registeredUserRepository.save(new RegisteredUser(newUser2));
		registeredUserRepository.save(new RegisteredUser(newUser3));


		System.out.println(registeredUserRepository.findByName("Binod"));
	}
}
