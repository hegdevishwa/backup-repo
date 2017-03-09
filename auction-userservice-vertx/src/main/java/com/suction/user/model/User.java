package com.suction.user.model;

import java.util.Date;

import io.vertx.core.json.JsonObject;

public class User {

	private int userId;

	private String firstName;

	private String lastName;

	private String userName;

	private String password;

	private String address;

	private Date createDate;

	public User(int userId, String firstName, String lastName, String userName, String password, Date createDate) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.createDate = createDate;
	}

	public User(JsonObject json) {
		this.userId = json.getInteger("userid");
		this.firstName = json.getString("fname");
		this.lastName = json.getString("lname");
		this.userName = json.getString("username");
	}

	public User() {
		// default constructor
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
