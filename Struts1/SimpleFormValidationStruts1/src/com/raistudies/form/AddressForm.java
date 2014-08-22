package com.raistudies.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class AddressForm extends ActionForm {

	private static final long serialVersionUID = 7760412395861134002L;
	
	private String name = null;
	private String street = null;
	private String city = null;
	private String country = null;
	private int pin;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors errors = new ActionErrors(); 
		if(this.name == null || this.name.trim().equals(""))
			errors.add("name", new ActionMessage("errors.required","Name"));
		if(this.city == null || this.city.trim().equals(""))
			errors.add("city", new ActionMessage("errors.required","City"));
		if(this.pin == 0)
			errors.add("pin", new ActionMessage("errors.required","Pin"));
		return errors;
	}
	
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.name = null;
		this.street = null;
		this.city = null;
		this.country = null;
		super.reset(mapping, request);
	}

}
