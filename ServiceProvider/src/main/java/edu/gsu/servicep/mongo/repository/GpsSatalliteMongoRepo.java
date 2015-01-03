package edu.gsu.servicep.mongo.repository;

import javax.inject.Named;
import javax.inject.Singleton;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.gsu.servicep.dto.GpsSatallite;
@Named
@Singleton
public interface GpsSatalliteMongoRepo extends MongoRepository<GpsSatallite, String>{

}
