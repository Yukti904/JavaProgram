package com.ibm.wallet1.bean;

public class createAccountDetails {

 
		int accID;
	String phoneNumber;
		int balance;
		String name;
		String accountType;
		
		public void setaccID(int accID) {
			this.accID = accID;
		}

		public int getaccID() {
			return accID;
		}
		public void setBalance(int balance) {
			this.balance = balance;
		}

		  public int getBalance() {
			  return balance;
		  }
		
		public void setphoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public String getphoneNumber() {
			return phoneNumber;
		}
		public void setName(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
		public void setAccountType(String accountType) {
			this.accountType = accountType;
		}

		public String getAccountType() {
			return accountType;
		}
		
		@Override
		public String toString() {
			return "Account Holder's details : name" + name + "Phone number : " + phoneNumber + "Account id : " + accID + "with balance : " + balance;
		}
				
	}


