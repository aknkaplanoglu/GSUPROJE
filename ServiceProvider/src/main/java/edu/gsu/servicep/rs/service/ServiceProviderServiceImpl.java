package edu.gsu.servicep.rs.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import edu.gsu.servicep.dto.UserDto;
import edu.gsu.servicep.mongo.repository.UserMongoRepositoryService;
import edu.gsu.servicep.request.dto.LoginWebDto;
import edu.gsu.servicep.response.dto.LoginResponseWebDto;

@Service("serviceProviderRsService")
public class ServiceProviderServiceImpl implements ServiceProviderRsService {

	@Inject
	UserMongoRepositoryService userMongoRepositoryService;

	@Override
	public String islogin(String username, String password) {

		return userMongoRepositoryService.isLoginSuccesful(username, password);
	}

	@Override
	public boolean createNewUser(String userName, String password,
			String telImei) {

		return userMongoRepositoryService.createNewUser(userName, password,
				telImei);
	}

	@Override
	public LoginResponseWebDto isloginWeb(LoginWebDto loginWebDto) {
		LoginResponseWebDto loginWeb = userMongoRepositoryService.isLoginWeb(loginWebDto);
		return loginWeb;
	}

	@Override
	public void giveRole(String username, String password) {
		userMongoRepositoryService.giveRole(username,password);
	}

	@Override
	public List<UserDto> bringUserNames(String userName) {
		
		
		return userMongoRepositoryService.bringUserNames(userName);
	}

}
