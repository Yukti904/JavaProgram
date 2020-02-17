package com.ibm.wallet1.ui;
import java.util.*;

import com.ibm.wallet1.bean.createAccountDetails;
import com.ibm.wallet1.bean.transactionDetails;
import com.ibm.wallet1.service.*;

public class walletMain {

	public static void main(String[] args) {
		System.out.println("Welcome t your wallet!");
		System.out.println("Press one of the below buttons to get respective details of your wallet");
		System.out.println("Enter the choice");
				System.out.println("1.Create Account "); 
				System.out.println("2.FetchDetails"); 
				System.out.println("3.Deposit "); 
				System.out.println("4.Withdraw");
				System.out.println("5.Check Balance"); 
				System.out.println("6.Fund Transfer "); 
				System.out.println("7 Print Transactions");
		Scanner s = new Scanner(System.in);
		int choice = s.nextInt();
		Serviceclass service = new Serviceclass();
		createAccountDetails det = new createAccountDetails();
		transactionDetails t1 = new transactionDetails();
		
		switch(choice)
		{
		case 1:
			service.createAccount(det);
			break;
			
			
		case 2:
			service.fetchAccDetails(det);
			break;
			
		case 3:
			System.out.println("Enter the amount to be deposited : ");
			int amount1 = s.nextInt();
			System.out.println("Enter the account ID where the amount to be deposited : ");
			int accId1 = s.nextInt();
			service.deposit(amount1, accId1);
			break;
			
		case 4:
			System.out.println("Enter the amount to be withdrawn : ");
			int amount2 = s.nextInt();
			System.out.println("Enter the account ID from where the amount is withdrawn : ");
			int accId2 = s.nextInt();
			service.withdraw(amount2, accId2);
			break;
			
		case 5:
			service.checkBalance(det);
			break;
			
		case 6:
			System.out.println("Enter the account number where the amount is debited: ");
			int accID1=s.nextInt();
			System.out.println("Enter the account number where the amount is credited : ");
			int accID2=s.nextInt();
			System.out.println("Enter the amount to be transferred");
			int amount3 = s.nextInt();
			service.fundTransfer(accID1, accID2, amount3);
			break;
		
		
		  case 7: 
			  System.out.println("Enter the account number to view transaction details : ");
			  int accID3 = s.nextInt();
			  service.printTransaction(t1,accID3);
			  break;
	
		 
			default:
				System.out.println("Invalid option");
			
			
		}
		
		
		


	}

}

