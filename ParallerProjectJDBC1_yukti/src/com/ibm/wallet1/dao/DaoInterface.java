package com.ibm.wallet1.dao;

import com.ibm.wallet1.bean.createAccountDetails;
import com.ibm.wallet1.bean.transactionDetails;

public interface DaoInterface {
	void createAccount(createAccountDetails det);
	void deposit(int amount, int accID);
	void withdraw(int amount, int accID);
	void fetchAccDetails(createAccountDetails det);
	void checkBalance(createAccountDetails det);
	void fundTransfer(int fromAccID, int toAccID, int amount);
	void printTransaction(transactionDetails t , int accID);

}
