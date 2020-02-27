package com.check;

import java.util.Scanner;




public class PrintBalanceSpringUI {
	public PrintBalanceSpringUI(BeanVariable b, WalletSpringServiceClass service) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the acount holder contact number");
		double holderContactNumber = scan.nextDouble();
		scan.nextLine();
		b.setHolderContactNumber(holderContactNumber);
		
		System.out.println(service.serveGetBalance(b));
	}
}
