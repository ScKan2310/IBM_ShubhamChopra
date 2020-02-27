package com.check;

import java.util.Scanner;



public class DepositFundsSpringUI {
	public DepositFundsSpringUI(BeanVariable b , WalletSpringServiceClass service) {
		Scanner scan = new Scanner(System.in);
		java.util.Date d = new java.util.Date();
		java.sql.Date d1 = new java.sql.Date(d.getTime());
		b.setTransactionTime(d1);
		
		System.out.println("Enter Deposit Amount");
		int ammountDeposit = scan.nextInt();
		b.setTransctionAmount(ammountDeposit);
		
		System.out.println("Enter the depositers contact number");
		double holderContactNumber = scan.nextDouble();
		scan.nextLine();
		b.setHolderContactNumber(holderContactNumber);
		
		if(service.serveDepositInAccount(b))
			System.out.println("Amount Deposited");
		else
			System.out.println("Amount not deposited");
	}
}
