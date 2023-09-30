package com.rse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.data.annotation.Persistent;

@Entity(name="Merchant")
@Table(name = "Merchant")
public class Merchant implements Comparable<Merchant> {

	@Id
	@Column(name = "id")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "CONTACT")
	private String contact;

	@Column(name = "NAME")
	private String name;

	@Column(name = "BUSINESS_NAME")
	private String businessName;

	@Column(name = "BUSINESS_CATEGORY")
	private String businessCategory;

	@Column(name = "CITY")
	private String cityName;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Transient
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Merchant o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getBusinessCategory() {
		return businessCategory;
	}

	public void setBusinessCategory(String businessCategory) {
		this.businessCategory = businessCategory;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
