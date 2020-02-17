package com.ibm.wallet1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.ibm.wallet1.bean.createAccountDetails;
import com.ibm.wallet1.bean.transactionDetails;

public class DaoClass implements DaoInterface {
	Connection dbCon;
	PreparedStatement pstmt;
	Scanner scan = new Scanner(System.in);
	createAccountDetails abc = new createAccountDetails();

	public DaoClass() {
		try {
			dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3307/ibmwalletdetails?serverTimezone=UTC",
					"root", "");

		} catch (SQLException e) {
			System.out.println("Error during connecting : " + e.getMessage());
		}

	}

	public void createAccount(createAccountDetails det) {
		String query = "INSERT INTO accdetails(Name , Phone_Number, Account_type , Balance) VALUES (?,?,?,?)";
		try {
			pstmt = dbCon.prepareStatement(query);
			System.out.println("Enter customer name : ");
			String name = scan.nextLine();
			System.out.println("Enter your phone number : ");
			String phoneNumber = scan.nextLine();

			System.out.println("Enter account type");
			String accountType = scan.nextLine();
			System.out.println("Enter the account balance");
			int balance = scan.nextInt();
			scan.nextLine();
			pstmt.setString(1, name);
			pstmt.setString(2, phoneNumber);
			pstmt.setString(3, accountType);
			pstmt.setInt(4, balance);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error while creating new account " + e.getMessage());
		}

	}

	public void deposit(int amount, int accID) {
		/*
		 * UPDATE `accdetails` SET
		 * `Name`=[value-1],`Phone_Number`=[value-2],`Account_type`=[value-3],`
		 * Account_Number`=[value-4],`Balance`=[value-5] WHERE 1
		 */

		String query = "SELECT Balance FROM accdetails WHERE Account_Number = ?";
		try {
			pstmt = dbCon.prepareStatement(query);
			pstmt.setInt(1, accID);
			int updatedbalance = 0;
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int currentbalance = rs.getInt("Balance");
				// System.out.println("Current Balance : " + currentbalance );
				updatedbalance = currentbalance + amount;
				// System.out.println("Updated balance : " +updatedbalance);
			}
			String upQry = "UPDATE accdetails SET Balance = ? WHERE Account_Number = ?";
			pstmt = dbCon.prepareStatement(upQry);
			pstmt.setInt(1, updatedbalance);
			pstmt.setInt(2, accID);
			pstmt.executeUpdate();

			String inQry = "INSERT INTO transactiondetails(transactionID , Time, from_accID, to_accID)"
					+ "VALUES (NULL,current_timestamp(),?,0)";

			pstmt = dbCon.prepareStatement(inQry);
			pstmt.setInt(1, accID);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Exception occurred during deposit : " + e.getMessage());
		}
	}

	/*
	 * try { pstmt = dbCon.prepareStatement(query);
	 * System.out.println("Enter the deposit amount"); int amount1 = scan.nextInt();
	 * int curr_bal = abc.getBalance(); if(curr_bal < 0) {
	 * System.out.println("Low balance"); } else { int updated_bal = curr_bal +
	 * amount;
	 * 
	 * pstmt.setInt(1,updated_bal); pstmt.setInt(2, accID); String qry =
	 * "INSERT INTO 'transactionDetails'('transactionID','Time','from_accID','to_accID') VALUES (NULL, current_timestamp(), ? , 'Bank')"
	 * ; pstmt = dbCon.prepareStatement(qry); pstmt.setInt(1, accID);
	 * pstmt.executeUpdate();
	 * 
	 * }catch(SQLException e) { System.out.println("Error while depositing " +
	 * e.getMessage()); } }
	 */

	public void withdraw(int amount, int accID) {

		String selQry = "SELECT Balance FROM accdetails WHERE Account_Number = ?";
		int updatedbalance = 0;
		try {
			pstmt = dbCon.prepareStatement(selQry);
			pstmt.setInt(1, accID);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int currentbalance = rs.getInt("Balance");
				// System.out.println("Current Balance : " + currentbalance );
				updatedbalance = currentbalance - amount;
				// System.out.println("Updated balance : " +updatedbalance);
			}

			String upQry = "UPDATE accdetails SET Balance = ? WHERE Account_Number = ?";
			pstmt = dbCon.prepareStatement(upQry);
			pstmt.setInt(1, updatedbalance);
			pstmt.setInt(2, accID);

			pstmt.executeUpdate();

			String insertQry = "INSERT INTO transactiondetails(transactionID, Time, from_accID, to_accID)"
					+ " VALUES (NULL,current_timestamp(),0,?)";

			pstmt = dbCon.prepareStatement(insertQry);

			pstmt.setInt(1, accID);

			pstmt.executeUpdate();
		}

		catch (SQLException e) {
			System.out.println("Exception occurred during withdrawal : " + e.getMessage());
		}
	}

	/*
	 * String query = "UPDATE accDetails SET Balance = ? WHERE Account_Number = ?";
	 * 
	 * try { pstmt = dbCon.prepareStatement(query);
	 * 
	 * System.out.println("Enter the withdraw amount"); int amount = scan.
	 * 
	 * int curr_bal = abc.getBalance(); int updated_bal = curr_bal + amount;
	 * pstmt.setInt(1, updated_bal); pstmt.setInt(2, accID); String qry =
	 * "INSERT INTO 'transactionDetails'('transactionID','Time','from_accID','to_accID') VALUES (NULL, current_timestamp(), 'Bank' , ?)"
	 * ; pstmt = dbCon.prepareStatement(qry); pstmt.setInt(1, accID);
	 * pstmt.executeUpdate();
	 * 
	 * } catch (SQLException e) { System.out.println("Error while withdrawing " +
	 * e.getMessage()); } }
	 */
	public void fetchAccDetails(createAccountDetails det) {
		
		try {
			Statement stmt = dbCon.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM accDetails");
			while (rs.next()) {

				String name = rs.getString(1);
				String phoneNumber = rs.getString(2);
				String accountType = rs.getString(3);
				int accID = rs.getInt(4);
				int balance = rs.getInt(5);
				System.out.println("Account details are as follows : Name " + name + " , Mobile no " + phoneNumber
						+ " , Account type : " + accountType + " , Account balance " + balance);

			}
		} catch (SQLException e) {
			System.out.println("Error while fetching account details " + e.getMessage());
		}
	}

	public void checkBalance(createAccountDetails det) {
		/*
		 * try{ Statement stmt = dbCon.createStatement(); ResultSet rs =
		 * stmt.executeQuery("SELECT * FROM accdetails"); while(rs.next()) { int accId =
		 * rs.getInt(1); String name = rs.getString(2); String phoneNumber =
		 * rs.getString(3); String accType = rs.getString(4); int accBalance =
		 * rs.getInt(5);
		 * 
		 * System.out.println("Account ID : " + accId + "Customer Name : "+ name +
		 * "Customer PhoneNumber : " + phoneNumber + "Account Type : " + accType +
		 * "Account Balance : " + accBalance); } }
		 * 
		 * catch(SQLException e) {
		 * System.out.println("Exception occurred during displaying the table : " +
		 * e.getMessage()); } } private Statement createStatement() { // TODO
		 * Auto-generated method stub return null; }
		 */
		
		String query = "SELECT Balance FROM accDetails WHERE Account_Number = ?";
		try {
			System.out.println("Enter the account number to check balance");
			int accID = scan.nextInt();
			pstmt = dbCon.prepareStatement(query);
			pstmt.setInt(1, accID);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int bal = rs.getInt("Balance");
				System.out.println("The account balance is : " + bal);
				if (bal < 2000) {
					System.out.println("Low balance");
				}
			}
		} catch (SQLException e) {
			System.out.println("Error while checking balance " + e.getMessage());
		}
	}

	public void fundTransfer(int fromAccID, int toAccID, int amount) {
		try {
			String Qry = "SELECT Balance FROM accdetails WHERE Account_Number = ?";
	         
	         
	         int updatedbalance1 = 0;
	         pstmt = dbCon.prepareStatement(Qry);
	         pstmt.setInt(1, fromAccID);
	         ResultSet rs= pstmt.executeQuery();
				while(rs.next()) {
	           int currentbalance1 = rs.getInt("Balance");
	           //System.out.println("Current Balance : " + currentbalance1 );
	           updatedbalance1 = currentbalance1 - amount;
	           //System.out.println("Updated balance : " +updatedbalance1);
				}
	         
	        
	         String Qry1 = " UPDATE accdetails SET accdetails.Balance = ? "
	          		+ "WHERE accdetails.Account_Number=?";   
	         pstmt=dbCon.prepareStatement(Qry1);
	         pstmt.setInt(1, updatedbalance1);
	         pstmt.setInt(2, fromAccID);
	         
	         pstmt.executeUpdate();
	         
	         String Qryy = "SELECT Account_Balance FROM accdetails WHERE Account_Number = ?";
	         pstmt=dbCon.prepareStatement(Qryy);
	         int updatedbalance2=0;
	         pstmt = dbCon.prepareStatement(Qry);
	         pstmt.setInt(1, toAccID);
	         ResultSet rs1= pstmt.executeQuery();
				while(rs1.next()) {
	        int currentbalance2 = rs1.getInt("Balance");
	        //System.out.println("Current Balance : " + currentbalance2 );
	        updatedbalance2 = currentbalance2 + amount;
	        //System.out.println("Updated balance : " +updatedbalance2);
				}
			
				
				
				
				String Qry2 = "UPDATE accdetails SET accdetails.Balance = ?"
		          		+ " WHERE accdetails.Account_Number=?";
				pstmt=dbCon.prepareStatement(Qry2);
	         pstmt.setInt(1, updatedbalance2);
	         pstmt.setInt(2, toAccID);
	         pstmt.executeUpdate();
	         
	         String Qry3 = "INSERT INTO transactiondetails(transactionID, Time, from_accID, to_accID)" 
	         	       + "VALUES (NULL,current_timestamp(),?,?)";
	         
	         pstmt = dbCon.prepareStatement(Qry3);
	         pstmt.setInt(1, fromAccID);
	         pstmt.setInt(2, toAccID);
	         
	         pstmt.executeUpdate();
		}
		
		catch(SQLException e)
		{
			System.out.println("Exception Occurred during fund transfer : " + e.getMessage());
		}
	}

		

	public void printTransaction(transactionDetails t, int accID) {
		try{
			Statement stmt = dbCon.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM transactiondetails");
			while(rs.next())
			{
				if((rs.getInt("from_accID")==(accID)||rs.getInt("to_accID")==(accID)))
				{
				int transId = rs.getInt(1);
				String time = rs.getString(2);
				int fromacc = rs.getInt(3);
				int toacc = rs.getInt(4);
				System.out.println("Transaction ID : " + transId + " Transaction time : "+ time + " Debit Account :  "  
						+ fromacc + " Credit Account : " + toacc);
				}
				
			
			}
		}
		
		catch(SQLException e) {
			System.out.println("Exception occurred during displaying the table : " + e.getMessage());
		}
	}
		

}
