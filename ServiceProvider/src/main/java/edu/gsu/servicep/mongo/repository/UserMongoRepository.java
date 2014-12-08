package edu.gsu.servicep.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.gsu.servicep.dto.UserDto;

public interface UserMongoRepository extends MongoRepository<UserDto, String>{
	

}
