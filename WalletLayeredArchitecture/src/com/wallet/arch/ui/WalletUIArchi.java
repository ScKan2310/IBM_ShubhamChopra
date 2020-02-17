package com.wallet.arch.ui;

import java.util.Scanner;

import com.wallet.arch.bean.Bean;
import com.wallet.arch.service.WalletServiceArchi;

public class WalletUIArchi {
	
	
	
 	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Bean b = new Bean();
		WalletServiceArchi service = new WalletServiceArchi();
		
		while(true) {
			System.out.println("Press 1 for inserting a new customer");
			System.out.println("Press 2 for updating an existing customer name");
			System.out.println("Press 3 for updating an existing customer name");
			System.out.println("Press 4 for deposit any amount");
			System.out.println("Press 5 for withdarwing any amount");
			System.out.println("Press 6 for tranfering funds");
			System.out.println("Press 7 for printing balance of the account");
			System.out.println("Press 8 for printig all transactions");
			System.out.println("Press 9 for printing accountdetails of all customers");
			System.out.println("Press 10 for halting");
			int n = scan.nextInt();
			scan.nextLine();
			switch(n) {
			case 1:
				new InsertUI(b,service); 
				break;
			case 2:
				new UpdateNameUI(b, service);
				break;
			case 3:
				new UpdateNumberUI(b, service);
				break;
			case 4:
				new DepositFunds(b, service);
				break;
			case 5: 
				new WithdrawFunds(b, service);
				break;
			case 6:
				new FundTransfer(b, service);
				break;
			case 7:
				new PrintBalanceUI(b, service);
				break;
			case 8:
				new PrintAllTransactionUI(b, service);
				break;
			case 9:
				new PrintAllData(b, service);
				break;
			case 10:
				n=11;
				break;
			default:
				break;
			}
			if(n==11)
				break;
		}
	}
 	
 	public static void problemConnection(Bean b) {
		System.out.println("problem while connecting " + b.getException());
	}
	
	public static void problemInserting(Bean b) {
		System.out.println("problem while inserting " + b.getException());
	}
	
	public static void problemUpdatingName(Bean b) {
		System.out.println("problem while updating name " + b.getException());
	}
	
	public static void problemUpdatingNumber(Bean b) {
		System.out.println("problem while updating number " + b.getException());
	}
	
	public static void problemGettingBalance(Bean b) {
		System.out.println("problem while printing balance " + b.getException());
	}
	
	public static void problemCheckingBalance(Bean b) {
		System.out.println("problem while checking balance " + b.getException());
	}
	
	public static void problemDepositing(Bean b) {
		System.out.println("problem while depositing funds " + b.getException());
	}
	
	public static void problemWithdrawing(Bean b) {
		System.out.println("problem while withdrawing funds " + b.getException());
	}
	
	public static void problemPrintingTransaction(Bean b) {
		System.out.println("problem while printing transactions " + b.getException());
	}
	
	public static void problemPrintingData(Bean b) {
		System.out.println("problem while printing data " + b.getException());
	}
	
	public static void printNoFunds(Bean b) {
		System.out.println("not enough funds");
	}
}
