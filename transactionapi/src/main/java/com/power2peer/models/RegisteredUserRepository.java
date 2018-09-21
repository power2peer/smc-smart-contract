package com.power2peer.models;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "registeredusers", path = "registeredusers")
public interface RegisteredUserRepository extends MongoRepository<RegisteredUser, String> {

	public RegisteredUser findByName(@Param("name") String name);

}