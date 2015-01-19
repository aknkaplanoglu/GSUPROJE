package edu.gsu.servicep.rs.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import edu.gsu.servicep.dto.GpsSatallite;
import edu.gsu.servicep.dto.UserDto;
import edu.gsu.servicep.request.dto.LoginWebDto;
import edu.gsu.servicep.request.dto.MapRequest;
import edu.gsu.servicep.response.dto.LoginResponseWebDto;

@Path("v1")
public interface ServiceProviderRsService {

	
	
	@GET
	@Path("islogin/{username}/{password}")
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	public String islogin(@PathParam("username")String username,@PathParam("password")String password);
	
	@GET
    @Path("createNewUser/{userName}/{password}/{telImei}")
    @Consumes("application/json;charset=UTF-8")
    @Produces("application/json;charset=UTF-8")
    public boolean createNewUser(@PathParam("userName") String userName, @PathParam("password") String password, @PathParam("telImei") String telImei);
	
	
	
	@GET
    @Path("bringUserNames/{userName}")
    @Consumes("application/json;charset=UTF-8")
    @Produces("application/json;charset=UTF-8")
    public List<UserDto> bringUserNames(@PathParam("userName") String userName);
	
	
	
	@POST
	@Path("isloginWeb")
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	public LoginResponseWebDto isloginWeb(LoginWebDto loginWebDto);
	
	@POST
	@Path("getLocationWeb")
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	public List<GpsSatallite> getLocationWeb(MapRequest mapRequest);
	
	@GET
	@Path("giveRole/{username}/{password}/{role}")
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	public String giveRole(@PathParam("username")String username,@PathParam("password")String password,@PathParam("role")String role);
	
	
	@POST
	@Path("sendLocation")
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	public String sendLocation(GpsSatallite gpsSatallite);
	
	
	
	

}
