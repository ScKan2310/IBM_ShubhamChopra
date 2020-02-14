package com.wallet.arch.ui;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.wallet.arch.bean.Bean;
import com.wallet.arch.service.WalletServiceArchi;

public class PrintBalanceUI {
	public PrintBalanceUI(Bean b, WalletServiceArchi service) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the acount holder contact number");
		double holderContactNumber = scan.nextDouble();
		scan.nextLine();
		b.setHolderContactNumber(holderContactNumber);
		
		Bean rs = service.serveGetBalance(b);
		System.out.println("the account balance is : " + rs.getAccountBalance());
	}
}
