package com.manulife.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Profile {
	
	@Id
	//@GeneratedValue
	private String email;
	private String firstName;
	private String lastName;
	private String dob;
	private String address;
	private String city;
	private String state;
	private String country; 
	private String zipcode;
	private String phoneNumber;
	private String sessionId;

	public Profile() {
		
	}
	public Profile(String email, String firstName, String lastName, String dob, String address, String city, String state, String country, String zipcode, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob=dob;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipcode = zipcode;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.sessionId = "";
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
		
}
