package com.ibm.wallet.service;

import java.sql.SQLException;


public interface serviceInterface {
	public void deposit(int amount, int accNo) throws SQLException;

	public void Withdraw(int amount, int accNo) throws SQLException;

	public String AccountDetails(String name) throws SQLException;
	
	public int getBalance(int accNo) throws SQLException ;
	
	public void fundTransfer(int accNo1, int accNo2 , int amount ) throws SQLException;
	
	public void createNewAccount(String name, String accountType) throws SQLException ;
	
	public String transactionDetails(String accNo) throws SQLException ;
}