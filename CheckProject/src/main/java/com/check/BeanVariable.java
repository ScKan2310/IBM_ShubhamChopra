package com.check;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("beanclass")
public class BeanVariable {
	int accountNumber;
	String holderName;
	double holderContactNumber;
	int accountBalance;
	int transactionNumber;
	int transctionAmount;
	Date transactionTime;
	String exception;

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public double getHolderContactNumber() {
		return holderContactNumber;
	}

	public void setHolderContactNumber(double holderContactNumber) {
		this.holderContactNumber = holderContactNumber;
	}

	public int getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}

	public int getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(int transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	public int getTransctionAmount() {
		return transctionAmount;
	}

	public void setTransctionAmount(int transctionAmount) {
		this.transctionAmount = transctionAmount;
	}

	public Date getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(Date transactionTime) {
		this.transactionTime = transactionTime;
	}

	@Override
	public String toString() {
		return "the transaction number is : " + this.transactionNumber + " ," + "  the account number is : "
				+ this.accountNumber + " ," + "  the transaction ammount is : " + this.transctionAmount + " ,"
				+ "  the transaction date is : " + this.transactionTime;
	}

	public String printData() {
		return "  the account number is : " + this.accountNumber + " ," + "  the name is : " + this.holderName + " ,"
				+ "  the contact number is : " + this.holderContactNumber + " ," + "  the account balance is : "
				+ this.accountBalance;
	}
}
