package edu.gsu.servicep.rs.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import edu.gsu.servicep.request.dto.LoginWebDto;
import edu.gsu.servicep.response.dto.LoginResponseWebDto;

@Path("v1")
public interface ServiceProviderRsService {

	
	
	@GET
	@Path("islogin/{username}/{password}")
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	public boolean islogin(@PathParam("username")String username,@PathParam("password")String password);
	
	@GET
    @Path("createNewUser/{userName}/{password}/{telImei}")
    @Consumes("application/json;charset=UTF-8")
    @Produces("application/json;charset=UTF-8")
    public boolean createNewUser(@PathParam("userName") String userName, @PathParam("password") String password, @PathParam("telImei") String telImei);
	
	
	@POST
	@Path("isloginWeb")
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	public LoginResponseWebDto isloginWeb(LoginWebDto loginWebDto);
	
	@GET
	@Path("giveRole/{username}/{password}")
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	public void giveRole(@PathParam("username")String username,@PathParam("password")String role);
	
	

}
