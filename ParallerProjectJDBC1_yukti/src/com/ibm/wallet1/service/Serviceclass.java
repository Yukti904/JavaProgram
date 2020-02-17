package com.ibm.wallet1.service;

import com.ibm.wallet1.bean.createAccountDetails;
import com.ibm.wallet1.bean.transactionDetails;
import com.ibm.wallet1.dao.DaoClass;

public class Serviceclass {
         DaoClass dao = new DaoClass();
         
         public void createAccount(createAccountDetails a) {
        	 dao.createAccount(a);
         }
         public void deposit(int amount, int accID) {
        	 dao.deposit(amount, accID);
         }
         public void withdraw(int amount, int accID) {
        	 dao.withdraw(amount, accID);
         }
         public void fetchAccDetails(createAccountDetails b) {
        	 dao.fetchAccDetails(b);
         }
         public void checkBalance(createAccountDetails c) {
        	 dao.checkBalance(c);
         }
         public void fundTransfer(int fromAccID, int toAccID, int amount) {
        	 dao.fundTransfer(fromAccID, toAccID, amount);
         }
         public void printTransaction(transactionDetails t , int accID)
     	{
     		dao.printTransaction(t,accID);
     	}
        
}
