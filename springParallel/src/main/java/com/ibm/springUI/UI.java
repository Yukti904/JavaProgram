package com.ibm.springUI;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ibm.springService.*;
import com.ibm.springBean.User;

@Component("UI")
public class UI{
	@Autowired
	serviceClass service;
	Scanner scan = new Scanner(System.in);

	public void choose() {
		int choice = 0;

		while (choice != 7) {
			System.out.println("Welcome to your wallet ");
			System.out.println("Choose from the following options");
			System.out.println("Press 1 to create a new Bank Account:");
			System.out.println("Press 2 to deposit into the bank account");
			System.out.println("Press 3 to withdraw ");
			System.out.println("Press 4 to transfer Fund");
			System.out.println("Press 5 to print user data");
			System.out.println("Press 6 to check your Balance");
			System.out.println("Press 7 to close the application");

			choice = scan.nextInt();
			scan.nextLine();

			switch (choice) {
			case 1:
				System.out.println("Enter name");
				String name = scan.nextLine();

				System.out.println("Enter phone Number");
				int no = scan.nextInt();
				scan.nextLine();

				User u1 = new User(name, no);

				service.insertUser(u1);
				break;
			case 2:
				System.out.println("Enter phone Number");
				String no1 = scan.nextLine();
				System.out.println("Enter deposit amount");
				int dep_amount = scan.nextInt();

				User u2 = new User(no1, dep_amount);
				service.deposit(u2);
				break;
			case 3:
				System.out.println("Enter phone Number");
				String no2 = scan.nextLine();
				System.out.println("Enter amount to withdraw");
				int withdraw_amt = scan.nextInt();

				User u3 = new User(no2, withdraw_amt);

				service.withdraw(u3);

				break;

			case 4:
				System.out.println("Enter phone Number to transfer amount");
				int toNumber = scan.nextInt();
				System.out.println("Enter your phone number");
				int userNumber = scan.nextInt();
				System.out.println("Enter amount to transfer");
				int amount = scan.nextInt();

				User u4 = new User(toNumber, userNumber, amount);
				service.transfer(u4);
				break;

			case 5:
				System.out.println("Enter your phone Number");
				int no3 = scan.nextInt();

				User u5 = new User(no3);

				System.out.println(service.allUserData(u5));

				break;

			case 6:
				System.out.println("Enter your phone Number");
				int no4 = scan.nextInt();

				User u6 = new User(no4);

				String ans = service.checkBalance(u6);
				System.out.println(ans);

				break;

			case 7:
				System.exit(0);

			default:
				continue;

			}

		}

	}

}
