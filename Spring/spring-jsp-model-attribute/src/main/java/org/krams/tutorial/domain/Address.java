package org.krams.tutorial.domain;

import java.io.Serializable;

/**
 * A simple POJO representing an Address
 */
public class Address  implements Serializable {
	
	private static final long serialVersionUID = -4480758500585143259L;
	private Integer id;
	private String street;
	private String zipCode;
	private String city;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
}
