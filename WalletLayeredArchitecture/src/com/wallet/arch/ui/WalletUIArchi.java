package com.wallet.arch.ui;

import java.sql.SQLException;
import java.util.Scanner;

import com.wallet.arch.bean.Bean;
import com.wallet.arch.service.WalletServiceArchi;

public class WalletUIArchi {
	public static void problemConnection(SQLException e) {
		System.out.println("problem while connecting " + e.getMessage());
	}
	
	public static void problemInserting(SQLException e) {
		System.out.println("problem while inserting " + e.getMessage());
	}
	
	public static void problemUpdatingName(SQLException e) {
		System.out.println("problem while updating name " + e.getMessage());
	}
	
	public static void problemUpdatingNumber(SQLException e) {
		System.out.println("problem while updating number " + e.getMessage());
	}
	
	public static void problemGettingBalance(SQLException e) {
		System.out.println("problem while printing balance " + e.getMessage());
	}
	
	public static void problemCheckingBalance(SQLException e) {
		System.out.println("problem while checking balance " + e.getMessage());
	}
	
	public static void problemDepositing(SQLException e) {
		System.out.println("problem while depositing funds " + e.getMessage());
	}
	
	public static void problemWithdrawing(SQLException e) {
		System.out.println("problem while withdrawing funds " + e.getMessage());
	}
	
	public static void problemPrintingTransaction(SQLException e) {
		System.out.println("problem while printing transactions " + e.getMessage());
	}
	
	public static void problemPrintingData(SQLException e) {
		System.out.println("problem while printing data " + e.getMessage());
	}
	
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
}
