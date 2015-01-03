package edu.gsu.servicep.mongo.repository;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import edu.gsu.servicep.dto.GpsSatallite;
import edu.gsu.servicep.request.dto.MapRequest;

@Named
@Singleton
public class GpsSatalliteMongoRepoService {

	@Autowired
	MongoTemplate mongoTemplate;
	@Inject
	GpsSatalliteMongoRepo gpsSatalliteMongoRepo;

	public String sendLocation(GpsSatallite gpsSatallite) {

		gpsSatallite.setLocationTime(new Date());
		gpsSatalliteMongoRepo.save(gpsSatallite);
		return "t";

	}

	public List<GpsSatallite> getLocationByDateAndUserName(MapRequest mapRequest) {

		Query query = new Query();
		Criteria criteria = Criteria.where("locationTime")
				.gte(mapRequest.getBaslamaZamani())
				.lte(mapRequest.getSonaErmeZamani()).and("userName")
				.is(mapRequest.getUserName());
		
		query.addCriteria(criteria);
		query.fields().include("location").exclude("_id");
		List<GpsSatallite> find = mongoTemplate.find(query,GpsSatallite.class);
		System.out.println(find.size());
		
		return find;
		
		
		
		
	}

}
