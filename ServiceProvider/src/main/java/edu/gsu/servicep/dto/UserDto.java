package edu.gsu.servicep.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@XmlRootElement(name="UserDto")
@XmlAccessorType(XmlAccessType.FIELD)
@Document
public class UserDto {
	
	private String userName;
	private String password;
	private String imeiNo;
	
	@Id
	private String idMongo;
	private String role;
	private Date zamanBilgisi;
	
	
	
	
	
	public Date getZamanBilgisi() {
		return zamanBilgisi;
	}
	public void setZamanBilgisi(Date zamanBilgisi) {
		this.zamanBilgisi = zamanBilgisi;
	}
	public List<BigDecimal> getLocation() {
		return location;
	}
	public void setLocation(List<BigDecimal> location) {
		this.location = location;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getImeiNo() {
		return imeiNo;
	}
	public void setImeiNo(String imeiNo) {
		this.imeiNo = imeiNo;
	}
	public String getIdMongo() {
		return idMongo;
	}
	public void setIdMongo(String idMongo) {
		this.idMongo = idMongo;
	}
	
	
	

}
