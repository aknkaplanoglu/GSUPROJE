package edu.gsu.servicep.mongo.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Box;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.GeospatialIndex;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.drew.lang.GeoLocation;
import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.model.GeocoderRequest;
import com.google.common.collect.Lists;

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
		
//		mongoTemplate.indexOps(GpsSatallite.class).ensureIndex(new GeospatialIndex("location"));
		gpsSatalliteMongoRepo.save(gpsSatallite);
		return "t";

	}
	
	public static float distFrom(float lat1, float lng1) {
	    double earthRadius = 6371; //kilometers
	    float lat2=(float) 41.044066;
	    float lng2=(float) 29.001767;
	    double dLat = Math.toRadians(lat2-lat1);
	    double dLng = Math.toRadians(lng2-lng1);
	    double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
	               Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
	               Math.sin(dLng/2) * Math.sin(dLng/2);
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
	    float dist = (float) (earthRadius * c);

	    return dist;
	    }

	public List<GpsSatallite> getLocationByDateAndUserName(MapRequest mapRequest) {

		Query query = new Query();
		Criteria criteria = Criteria.where("locationTime")
				.gte(mapRequest.getBaslamaZamani())
				.lte(mapRequest.getSonaErmeZamani()).and("userName")
				.is(mapRequest.getUserName());
		
		query.addCriteria(criteria);
		query.fields().include("location").exclude("_id").include("speed").include("tip");
		List<GpsSatallite> find = mongoTemplate.find(query,GpsSatallite.class);

		
		return find;
		
	}
	

}

//List<GpsSatallite> gpsSatallites=new ArrayList<GpsSatallite>();
//for (GpsSatallite gpsSatallite : find) {
//	List<Double> reverse = Lists.reverse(gpsSatallite.getLocation());
//	gpsSatallite.setLocation(reverse);
//	gpsSatallites.add(gpsSatallite);
//}
//System.out.println(gpsSatallites.size());
