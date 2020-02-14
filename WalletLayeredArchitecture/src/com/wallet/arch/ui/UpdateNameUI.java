package com.wallet.arch.ui;

import java.util.Scanner;

import com.wallet.arch.bean.Bean;
import com.wallet.arch.service.WalletServiceArchi;

public class UpdateNameUI {
	public UpdateNameUI(Bean b,WalletServiceArchi service) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the account number to be updated");
		int accountNumber = scan.nextInt();
		scan.nextLine();
		b.setAccountNumber(accountNumber);
		
		System.out.println("Enter the new name");
		String newName = scan.nextLine();
		b.setHolderName(newName);
		if(service.serveUpdateName(b)>0)
			System.out.println("Name Updated");
		else
			System.out.println("Name not updated");
		
	}
}
