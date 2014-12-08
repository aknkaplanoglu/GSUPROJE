package edu.gsu.servicep.mongo.repository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import edu.gsu.servicep.dto.UserDto;
import edu.gsu.servicep.request.dto.LoginWebDto;
import edu.gsu.servicep.response.dto.LoginResponseWebDto;

@Named
@Singleton
public class UserMongoRepositoryService {

	@Autowired
	MongoTemplate mongoTemplate;
	@Inject
	UserMongoRepository userMongoRepository;

	public boolean isLoginSuccesful(String userName, String password) {
		Boolean bool = false;
		Criteria criteria = Criteria.where("userName").is(userName);
		Query query = new Query();
		query.addCriteria(criteria);
		query.limit(1);
		UserDto user = mongoTemplate.findOne(query, UserDto.class);
		if (user != null) {
			if (user.getPassword().equals(password)) {
				bool = true;
			}
		}

		return bool;
	}

	public boolean createNewUser(String userName, String password,
			String telImei) {
		Criteria criteria = Criteria.where("userName").is(userName);
		Query query = new Query(criteria);
		UserDto user = mongoTemplate.findOne(query, UserDto.class);
		if (user == null) {
			try {
				UserDto newUser = new UserDto();
				newUser.setUserName(userName);
				newUser.setPassword(password);
				newUser.setImeiNo(telImei);
				newUser.setRole("user");
				userMongoRepository.save(newUser);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}

	public LoginResponseWebDto isLoginWeb(LoginWebDto loginWebDto) {

		LoginResponseWebDto loginResponseWebDto = new LoginResponseWebDto();

		String userName = loginWebDto.getUserName();
		Criteria criteria = Criteria.where("userName").is(userName);
		System.out.println(userName+" --->>"+ loginWebDto.getPassword());
		Query query = new Query();
		query.addCriteria(criteria);
		query.limit(1);
		UserDto user = mongoTemplate.findOne(query, UserDto.class);
		if (user != null) {
			String password = loginWebDto.getPassword();
			if (user.getPassword().equals(password)) {
				loginResponseWebDto.setSuccess("Success");
				loginResponseWebDto.setRole(user.getRole());
			}
			else{
				loginResponseWebDto.setSuccess("notSuccess");
			}
		} else {
			loginResponseWebDto.setSuccess("notSuccess");
		}
		return loginResponseWebDto;

	}

	public void giveRole(String username, String role) {

		Criteria criteria = Criteria.where("userName").is(username);
		Query query = new Query();
		query.addCriteria(criteria);
		Update update = new Update();
		update.set("role", role);
		mongoTemplate.updateMulti(query, update, UserDto.class);

	}

}
