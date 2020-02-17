package com.ibm.wallet1.bean;
import java.sql.Date;

public class transactionDetails {
	private int transactionID, fromAccID, toAccID;
	Date transactionTime;
	
	public Date getTransactionTime() {
		return transactionTime;
	}
	public void setTransactionTime(Date transactionTime) {
		this.transactionTime = transactionTime;
	}
	
	public void settransactionID(int transactionID) {
		this.transactionID = transactionID;
	}
	public int gettransactionID() {
		return transactionID;
	}
	public void setfromAccID(int fromAccID) {
		this.fromAccID = fromAccID;
	}
	public int getfromAccID() {
		return fromAccID;
	}
	public void settoAccID(int toAccID) {
		this.toAccID = toAccID;
	}
	public int gettoAccID() {
		return toAccID;
	}
	@Override
	public String toString() {
		return "Transaction details  : transaction ID" + transactionID + "From Acc. id : " + fromAccID  + "To account id : " + toAccID;
	}
	

}
