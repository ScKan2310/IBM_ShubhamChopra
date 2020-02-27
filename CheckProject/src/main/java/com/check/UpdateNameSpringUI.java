package com.check;

import java.util.Scanner;





public class UpdateNameSpringUI {
	public UpdateNameSpringUI(BeanVariable b, WalletSpringServiceClass service) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the account number to be updated");
		int accountNumber = scan.nextInt();
		scan.nextLine();
		b.setAccountNumber(accountNumber);
		
		System.out.println("Enter the new name");
		String newName = scan.nextLine();
		b.setHolderName(newName);
		if(service.serveUpdateName(b))
			System.out.println("Name Updated");
		else
			System.out.println("Name not updated");
	}
}
