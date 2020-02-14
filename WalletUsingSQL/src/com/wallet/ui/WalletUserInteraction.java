package com.wallet.ui;

import java.util.Scanner;

import com.wallet.service.WalletService;

public class WalletUserInteraction {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		WalletService service = new WalletService();
		service.runDao();
		while(true) {
			System.out.println("Press 1 for inserting a new customer");
			System.out.println("Press 2 for updating an existing customer");
			System.out.println("Press 3 for deposity any amount");
			System.out.println("Press 4 for withdarwing any amount");
			System.out.println("Press 5 for tranfering funds");
			System.out.println("Press 6 for printing balance of the account");
			System.out.println("Press 7 for printig all transactions");
			System.out.println("Press 8 for printing accountdetails of all customers");
			System.out.println("Press 9 for halting");
			int n = scan.nextInt();
			scan.nextLine();
			if(n!=9)
				service.extractFunctinsOfDao(n);
			else
				break;
			
		}
	}
}
