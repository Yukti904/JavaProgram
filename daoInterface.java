package com.ibm.wallet.dao;


import java.sql.SQLException;

public interface daoInterface {

	void deposit(int amount, int accNo);

	void Withdraw(int amount, int accNo);

	String AccountDetails(String name);

	int getBalance(int accNo);
	
	void fundTransfer(int accNo1, int accNo2 , int amount );
	
	void createNewAccount(String name, String accountType);

	String transactionDetails(String accNo);

}