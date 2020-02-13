package com.ibm.wallet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class daoClass implements daoInterface {

	
	static Connection dbCon;
	   PreparedStatement pstmt;
	public daoClass() {
		try {
			dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3307/ibm20Jan?serverTimezone=UTC", "root", "");
			
		}
		 catch(SQLException e) {
			 System.out.println("Error during connecting : " + e.getMessage());
		 }
		
     
	}

	

	@Override
	public void deposit(int amount, int accNo)  {
		try {

		String query = "UPDATE accountDetails SET balance = ? WHERE accountNumber = ?";

		int curr_balance = this.getBalance(accNo);

		int new_balance = curr_balance + amount;

		pstmt = dbCon.prepareStatement(query);

		pstmt.setInt(1, new_balance);

		pstmt.setInt(2, accNo);

		query = "INSERT INTO `transactionDetails` (`transactionID`, `time`, `fromTime`, `toTime`) VALUES (NULL, current_timestamp(), ? , 'Bank');";

		pstmt = dbCon.prepareStatement(query);

		pstmt.setInt(1, accNo);
		
		pstmt.executeUpdate();

	} catch(SQLException e) {
		System.out.println("Error while depositing : " + e.getMessage());
	}
	}

	@Override
	public void Withdraw(int amount, int accNo){
      try {
		if (this.getBalance(accNo) - amount < 0) {
			System.out.println("Low balance");
		}

		else {

			String query = "UPDATE accountDetails SET balance = ? WHERE accountNumber = ?";

			int currBalance = this.getBalance(accNo);

			int newBalance = currBalance - amount;

			pstmt = dbCon.prepareStatement(query);

			pstmt.setInt(1, newBalance);

			pstmt.setInt(2, accNo);

			query = "INSERT INTO `transaction` (`transactionID`, `time`, `fromTime`, `toTime`) VALUES (NULL, current_timestamp(), 'Bank' , ?);";

			pstmt = dbCon.prepareStatement(query);

			pstmt.setInt(1, accNo);
			
			pstmt.executeUpdate();

		}

	} catch(SQLException e) {
		 System.out.println("Error while withdrawing : " + e.getMessage());
	}
	}
	

	@Override
	public String AccountDetails(String name){
		String result = "" ;
    try {
		String query = "SELECT * FROM accountDetails WHERE name = ?";

		pstmt = dbCon.prepareStatement(query);
		
		pstmt.setString(1, name);
		
		ResultSet rs = pstmt.executeQuery();
		
		
		
		while(rs.next()) {
			
			result += "Details of the customer are : Account number is  " + rs.getInt("accNumber") + " Name of customer  : " + rs.getString("name") + " Balance in your account : " + rs.getInt("balance") + " Account Type : " + rs.getString("accountType");                     
			
		}
		
		

	} catch(SQLException e) {
		System.out.println("Error while fetching details " + e.getMessage());
	}
    return result ;
	}

	@Override
	public int getBalance(int accNo)  {
		try {
		String query = "SELECT balance FROM account WHERE accountNumber = ?";
		
		pstmt = dbCon.prepareStatement(query);
		
		ResultSet rs = pstmt.executeQuery() ;
		
		
	   
		
		
		
	} catch(SQLException e) {
		System.out.println("Error while getting balance " + e.getMessage());
	}
		 return rs.getInt("balance") ;
	}

	@Override
	public void fundTransfer(int accNo1, int accNo2, int amount)  {
		try {
		if (this.getBalance(accNo1) - amount < 0) {
			System.out.println("Low balance");
		}

		else {

			String query1 = "UPDATE accountDetails SET balance = ? WHERE accountNumber = ?";
			String query2 = "UPDATE accountDetails SET balance = ? WHERE accountNumber = ?";

			int currBal1 = this.getBalance(accNo1);
			int currBal2 = this.getBalance(accNo2);

			int newBalance1 = currBal1 - amount;
			int newBalance2 = currBal2 + amount;

			pstmt = dbCon.prepareStatement(query1);
			
			pstmt.setInt(1, newBalance1);

			pstmt.setInt(2, accNo1);
			
			
			
			pstmt = dbCon.prepareStatement(query2);
			pstmt.setInt(1, newBalance2);

			pstmt.setInt(2, accNo2);
			
			
			String query = "INSERT INTO `transaction` (`transactionID`, `time`, `fromT`, `toT`) VALUES (NULL, current_timestamp(), ? , ?);";

			pstmt = dbCon.prepareStatement(query);

			pstmt.setInt(1, accNo1);
			pstmt.setInt(2, accNo2);
			
			pstmt.executeUpdate();

		}
	} catch(SQLException e) {
		System.out.println("Error while transferring " + e.getMessage());
	}
	
	}

	@Override
	public void createNewAccount(String name, String accountType)  {
		try {
		String query = "INSERT INTO accountDetails (accountNumber, name, balance, accountType) VALUES (NULL, ?, 0 , ?)";
		
		pstmt = dbCon.prepareStatement(query);

		pstmt.setString(1, name);

		pstmt.setString(2, accountType);
		
		pstmt.executeUpdate();
		
		
	} catch(SQLException e) {
	System.out.println("Error while creating account " + e.getMessage());
	}
	}

	@Override
	public String transactionDetails(String accNo)  {
		String result = "" ;
		try {
		String query = "SELECT * FROM transaction WHERE fromTime = ? OR toTime = ?";

		pstmt = dbCon.prepareStatement(query);
		
	pstmt.setString(1, accNo);
		pstmt.setString(2, accNo);
		
		ResultSet rs = pstmt.executeQuery();
		
		
		
		while(rs.next()) {
			
			if((rs.getString("fromTime").equals(accNo))||(rs.getString("toTime").equals(accNo))) {
			
			result += "Details are as follows : TransactionID : " + rs.getInt("transactionID") + " Time : " + rs.getString("time") + " From : " + rs.getString("fromTime") + " To : " + rs.getString("toTime");                     
			}	
		}
		
		
		
	} catch (SQLException e) {
		System.out.println("Error while printing " + e.getMessage());
	}
		return result;
		
		
		
		

}
	}
