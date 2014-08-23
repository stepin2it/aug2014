package com.stepin2it.stepin2it.androidlibrary;

import java.io.Serializable;

public class User implements Serializable
{
	
	private int id;
	
	private String username;
	
	private String firstname;
	
	private String lastname;
	
	private String city;
	
	private String country;
	
	private String fullname;
	
	private String userpic_url;
	
	private int upgrade_status;
	
	private int followers_count;
	
	private int affection;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getUserpic_url() {
		return userpic_url;
	}

	public void setUserpic_url(String userpic_url) {
		this.userpic_url = userpic_url;
	}

	public int getUpgrade_status() {
		return upgrade_status;
	}

	public void setUpgrade_status(int upgrade_status) {
		this.upgrade_status = upgrade_status;
	}

	public int getFollowers_count() {
		return followers_count;
	}

	public void setFollowers_count(int followers_count) {
		this.followers_count = followers_count;
	}

	public int getAffection() {
		return affection;
	}

	public void setAffection(int affection) {
		this.affection = affection;
	}
	
}
