package com.check;

import java.util.Scanner;



public class FundTransferSpringUI {
	public FundTransferSpringUI(BeanVariable b,WalletSpringServiceClass service) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the details for withdrawer");
		java.util.Date d = new java.util.Date();
		java.sql.Date d1 = new java.sql.Date(d.getTime());
		b.setTransactionTime(d1);
		
		System.out.println("Enter the amount to be withdrawn");
		int ammountDeposit = scan.nextInt();
		b.setTransctionAmount(ammountDeposit);
		
		System.out.println("Enter the withdarwer contact number");
		double holderContactNumber = scan.nextDouble();
		scan.nextLine();
		b.setHolderContactNumber(holderContactNumber);
		
		if(service.serveWithdrawFromAccount(b)) {
			System.out.println("Enter the details for depositer");
			b.setTransctionAmount(ammountDeposit);
		
			System.out.println("Enter the depositers contact number");
			holderContactNumber = scan.nextDouble();
			scan.nextLine();
			b.setHolderContactNumber(holderContactNumber);
		
			if(service.serveDepositInAccount(b))
				System.out.println("Amount Deposited");
			else
			System.out.println("Amount not deposited");
			System.out.println("Amount Withrawn");
		}
		else
			System.out.println("Amount not Withdrawn");
	}
}
