package com.wallet.arch.ui;

import java.util.Scanner;

import com.wallet.arch.bean.Bean;
import com.wallet.arch.service.WalletServiceArchi;

public class UpdateNumberUI {
	public UpdateNumberUI(Bean b, WalletServiceArchi service) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the account number to be updated");
		int accountNumber = scan.nextInt();
		scan.nextLine();
		b.setAccountNumber(accountNumber);
		
		System.out.println("Enter the new Number");
		double newNumber = scan.nextDouble();
		scan.nextLine();
		b.setHolderContactNumber(newNumber);
		
		if(service.serveUpdateNumber(b)>0)
			System.out.println("Number Updated");
		else
			System.out.println("Number not Updated");
		
		
	}
}
