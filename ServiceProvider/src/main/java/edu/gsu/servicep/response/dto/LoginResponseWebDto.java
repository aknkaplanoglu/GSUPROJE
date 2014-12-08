package edu.gsu.servicep.response.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="LoginResponseWebDto")
@XmlAccessorType(XmlAccessType.FIELD)
public class LoginResponseWebDto {
	
	private String role;
	private String success;
	
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	
	

}
