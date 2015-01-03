package edu.gsu.servicep.mongo.repository;

import javax.inject.Named;
import javax.inject.Singleton;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.gsu.servicep.dto.UserDto;
@Named
@Singleton
public interface UserMongoRepository extends MongoRepository<UserDto, String>{
	

}
