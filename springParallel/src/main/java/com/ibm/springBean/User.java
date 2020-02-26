package com.ibm.springBean;

import java.sql.Date;

public class User {
	int accNumber;
	String userName;
	int phoneNumber;
	int tophoneNumber;
	int Balance;
	int transactionNumber;
	Date transactionTime;

	public User(String name, int no) {
		userName = name;
		phoneNumber = no;

	}
	public User(Integer contactNo, Integer balance ) {
		super();
		this.Balance = balance;
		phoneNumber = contactNo;
	}	
	public User(Integer balance) {
		super();
		this.Balance = balance;
	}
	public User(int tophoneNo, int userphoneNo,Integer balance) {
		this.Balance = balance;
		this.tophoneNumber = tophoneNo;
	   userphoneNo = phoneNumber;
	}
	public User(int phoneNo) {
		super();
		phoneNumber = phoneNo;
	}
	
	public void setaccNumber(int accNumber) {
		this.accNumber = accNumber;
	}

	public int getaccNumber() {
		return accNumber;
	}

	public void setuserName(String userName) {
		this.userName = userName;
	}

	public String getuserName() {
		return userName;
	}

	public void setphoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getphoneNumber() {
		return phoneNumber;
	}

	public void settophoneNumber(int tophoneNumber) {
		this.tophoneNumber = tophoneNumber;
	}

	public int gettophoneNumber() {
		return tophoneNumber;
	}

	public void setBalance(int Balance) {
		this.Balance = Balance;
	}

	public int getBalance() {
		return Balance;
	}

	public void settransactionNumber(int transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	public int gettransactionNumber() {
		return transactionNumber;
	}

	@Override
	public String toString() {
		return getphoneNumber() + " " + getuserName() + " " + getBalance();
	}

}
