package com.check;

import java.util.Random;
import java.util.Scanner;





public class InsertSpringUI {
	
	public InsertSpringUI(BeanVariable b, WalletSpringServiceClass service) {
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		System.out.println("Enter the Holder Name");
		String holderName = scan.nextLine();
		b.setHolderName(holderName);
		
		System.out.println("Enter the Phone number");
		double holderContactNumber = scan.nextDouble();
		scan.nextLine();
		b.setHolderContactNumber(holderContactNumber);
				
		System.out.println("Enter the amount you want to deposit to start the amount");
		int accountBalance = scan.nextInt();
		scan.nextLine();
		b.setAccountBalance(accountBalance);
				
		int accountNumber = rand.nextInt(Integer.MAX_VALUE)+1;
		b.setAccountNumber(accountNumber);
		if(service.serveInsert(b))
			System.out.println("Account Created");
		else
			System.out.println("Account Not Created");
	}
}
