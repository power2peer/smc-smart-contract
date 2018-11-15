package com.power2peer.models;

import java.util.List;

import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "registeredusers", path = "registeredusers")
public interface RegisteredUserRepository extends MongoRepository<RegisteredUser, String> {

	public List<RegisteredUser> findAllByTypeOrderByPricePerKwhAsc(@Param("type") UserType type);

	public RegisteredUser findByName(@Param("name") String name);

	public List<RegisteredUser> findByType(@Param("type") UserType type);

	public List<RegisteredUser> findByTypeAndLocationNearOrderByPricePerKwhAsc(@Param("type") UserType type, 
			@Param("location") Point point,
			@Param("distance") Distance distance);

}