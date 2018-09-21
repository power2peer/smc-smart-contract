package com.power2peer.models;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

public interface RegisteredUserRepository extends MongoRepository<RegisteredUser, String> {

	public RegisteredUser findByName(@Param("name") String name);

}