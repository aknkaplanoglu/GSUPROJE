package edu.gsu.servicep.request.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="MapRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class MapRequest {
	
	private Date baslamaZamani;
	private Date sonaErmeZamani;
	private String userName;
	
	
	public Date getBaslamaZamani() {
		return baslamaZamani;
	}
	public void setBaslamaZamani(Date baslamaZamani) {
		this.baslamaZamani = baslamaZamani;
	}
	public Date getSonaErmeZamani() {
		return sonaErmeZamani;
	}
	public void setSonaErmeZamani(Date sonaErmeZamani) {
		this.sonaErmeZamani = sonaErmeZamani;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	

}
