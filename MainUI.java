package com.ibm.wallet.ui;

import java.sql.SQLException;
import com.ibm.wallet.service.serviceClass;

import java.util.Scanner;

	
	public class MainUI {
		
		

		public static void main(String[] args) {
			
			Scanner scan = new Scanner(System.in);


			try {
				serviceClass service = new serviceClass() ;
			
			
			String name;
			int amount, id , id1;
			String accountType;
			System.out.println("Welcome to online banking wallet");
			 System.out.println("Choose from the below options :");
			 System.out.println("To view balance press 7  ");
				System.out.println("Press 1 for Account Creation"); 
				 System.out.println("2 for making a deposit");
				System.out.println("3 for making a withdrawal"); 
				System.out.println("4 for transferring funds"); 
				System.out.println("5 for viewing your transaction details"); 
				 System.out.println("6 for viewing account details");
				System.out.println("For exit enter any random number ");
				
				int choice = scan.nextInt();

			
			
			
		switch(choice) {
		
		case 1:
			System.out.println("Enter the new account holder name");
			
			name = scan.next();
			
			System.out.println("Enter the account Type");
			
			accountType = scan.next() ;
			
			service.createNewAccount(name, accountType);
				break;
		case 2:

			System.out.println("Enter your Account Number");
			
			id = scan.nextInt() ;
			
			System.out.println("Enter the amount to be deposited");
			
			amount = scan.nextInt();
			
			service.deposit(amount, id);
		break;
		case 3:
			System.out.println("Enter your Account Number");

			id = scan.nextInt();

			System.out.println("Enter the amount to be withdrawn");

			amount = scan.nextInt();

			service.Withdraw(amount, id);
			break;
		case 4:

			System.out.println("Enter your account Number");
			
			id = scan.nextInt();

			System.out.println("Enter your account Number to transfer to");
			
			id1 = scan.nextInt();
			
			System.out.println("Enter the amount you want to transfer");
			
			amount = scan.nextInt();
			
			service.fundTransfer(id,id1,amount);
			break;
		case 5:
			System.out.println("Enter the name of the account holder");
			
			name = scan.next();
			
			System.out.println(service.transactionDetails(name.toString()));
			break;
		case 6:
			System.out.println("Enter the name of the account holder");

			name = scan.next();

			System.out.println(service.AccountDetails(name));
			break;
		case 7:

			System.out.println("Enter your account number");
			
			id = scan.nextInt();
			
			System.out.println(service.getBalance(id));
			break;
			default:
				System.out.println("Invalid option");
		break;			
				
			}
			
			} catch (SQLException e) {
				
				System.out.println("Errorrrrr....." + e.getMessage());
				
			} 
			
			
			

		}

	}


