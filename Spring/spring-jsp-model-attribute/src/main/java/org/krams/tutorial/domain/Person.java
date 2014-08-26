package org.krams.tutorial.domain;

import java.io.Serializable;

/**
 * A simple POJO representing a Person
 */
public class Person implements Serializable {

	private static final long serialVersionUID = -5527566248002296042L;
	
	private Integer id;
	private String firstName;
	private String lastName;
	private String currency;
	private Double money;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}
	
}
