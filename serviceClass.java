package com.ibm.wallet.service;

import java.sql.SQLException;

import com.ibm.wallet.dao.daoClass;


public class serviceClass {
	
	daoClass dao ;
	
	public serviceClass() throws SQLException{
		dao = new daoClass() ;
	}
	
		
	public void deposit(int amount, int accNo) throws SQLException {
		dao.deposit(amount, accNo);
	}

	public void Withdraw(int amount, int accNo) throws SQLException {
		dao.Withdraw(amount, accNo);
	}

	public String AccountDetails(String name) throws SQLException {
		return dao.AccountDetails(name);
	}
	
	public int getBalance(int accNo) throws SQLException {
		return dao.getBalance(accNo);
	}
	
	public void fundTransfer(int accNo1, int accNo2 , int amount ) throws SQLException{
		dao.fundTransfer(accNo1, accNo2, amount);
	}
	
	public void createNewAccount(String name, String accountType) throws SQLException {
		dao.createNewAccount(name, accountType);
	}
	
	public String transactionDetails(String accNo) throws SQLException{
		return dao.transactionDetails(accNo);
	}

}
