package com.ibm.wallet1.bean;

public class UserReg {
	private int userID;
	private String name;
	private String email;
	private String password;

	public void setUserId(int userID) {
		this.userID = userID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserId() {
		return userID;
	}

	public String getName() {
		return name;

	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

}
