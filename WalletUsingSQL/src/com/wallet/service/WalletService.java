package com.wallet.service;

import java.sql.Connection;
import java.util.Scanner;

import com.wallet.dao.*;

public class WalletService implements WalletServiceInterface  {
	WalletDao dao = new WalletDao();
	Connection dbCon;
	Scanner scan = new Scanner(System.in);
	
	@Override
	public Connection runDao() {
		dbCon = dao.getConnection(dbCon);
		return dbCon;
	}
	
	public void extractFunctinsOfDao(int n) {
		switch(n) {
		case 1:
			dao.insertData(dbCon);
			break;
		case 2:
			dao.updateData(dbCon);
			break;
		case 3:
			System.out.println("Enter the deposit amount");
			int transactionAmount = scan.nextInt();
			dao.depositInAccount(dbCon,transactionAmount);
			break;
		case 4:
			System.out.println("Enter the withdrawal amount");
			int transactionAmountWithdraw = scan.nextInt();
			dao.withdrawFromAccount(dbCon,transactionAmountWithdraw);
			break;
		case 5:
			dao.fundTransfer(dbCon);
			break;
		case 6:
			dao.getBalance(dbCon);
			break;
		case 7:
			dao.getTransaction(dbCon);
			break;
		case 8:
			dao.getAllData(dbCon);
			break;
		}
		
	}
}
