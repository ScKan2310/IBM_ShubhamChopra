package com.wallet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


public class WalletDao implements WalletDaoInterface {
	PreparedStatement pstmt ;
	PreparedStatement pstmt1 ;
	PreparedStatement pstm2;
	
	public Connection getConnection(Connection dbCon) {
		try {
			dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/wallet?serverTimezone=UTC", "root", "");
		} catch (SQLException e) {
			System.out.println("problem while connection "  + e.getMessage());
		}
		return dbCon;
	}
	
	@Override
	public void insertData(Connection dbCon) {
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		System.out.println("Enter the Holder Name");
		String holderName = scan.nextLine();
		System.out.println("Enter the Phone number");
		double holderContactNumber = scan.nextDouble();
		scan.nextLine();
		System.out.println("Enter the amount you want to deposit to start the amount");
		int accountBalance = scan.nextInt();
		scan.nextLine();
		int accountNumber = rand.nextInt(Integer.MAX_VALUE)+1;
		
		String insertQuery = "insert into accountDetails values(?,?,?,?)";
		try {
			pstmt = dbCon.prepareStatement(insertQuery);
			pstmt.setString(2, holderName);
			pstmt.setDouble(3, holderContactNumber);
			pstmt.setInt(4, accountBalance);
			pstmt.setInt(1, accountNumber);
			
			if(pstmt.executeUpdate()>0)
				System.out.println("account created");
			else
				System.out.println("account not created");
		} catch (SQLException e) {
			System.out.println("problem while inserting " + e.getMessage());
		}
	}
	
	@Override 
	public void updateData(Connection dbCon) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Press 1 to update Holder Name");
		System.out.println("Press 2 to update Holder Contact Number");
		int n= scan.nextInt();
		scan.nextLine();
		switch(n) {
		case 1:
			String queryNameUpdate = "update accountDetails set holderName = ? where accountNumber =?";
			try {
				pstmt = dbCon.prepareStatement(queryNameUpdate);
				System.out.println("Enter the account number to be updated");
				int accountNumber = scan.nextInt();
				scan.nextLine();
				System.out.println("Enter the new name");
				String newName = scan.nextLine();
				pstmt.setInt(2,accountNumber);
				pstmt.setString(1,newName);
				
				if(pstmt.executeUpdate()>0)
					System.out.println("Name updated");
				else
					System.out.println("name not updatable");
			} catch (SQLException e) {
				System.out.println("Problem while updating name "+ e.getMessage());
			}
			break;
		case 2:
			String queryNumberUpdate = "update accountDetails set holderContactNumber = ? where accountNumber =?";
			try {
				pstmt = dbCon.prepareStatement(queryNumberUpdate);
				System.out.println("Enter the account number to be updated");
				int accountNumber = scan.nextInt();
				System.out.println("Enter the new Number");
				double newNumber = scan.nextDouble();
				scan.nextLine();
				pstmt.setInt(2,accountNumber);
				pstmt.setDouble(1,newNumber);
				
				if(pstmt.executeUpdate()>0)
					System.out.println("Number updated");
				else
					System.out.println("number not updatable");
			} catch (SQLException e) {
				System.out.println("Problem while updating name "+ e.getMessage());
			}
			break;
		}
	}
	
	@Override
	public void getBalance(Connection dbCon) {
		Scanner scan = new Scanner(System.in);
		String queryGetBalance = " select accountBalance from accountDetails where holderContactNumber = ?";
		try {
			System.out.println("Enter the Holder Contact Number");
			double holderContactNumber = scan.nextDouble();
			scan.nextLine();
			
			pstmt = dbCon.prepareStatement(queryGetBalance);
			pstmt.setDouble(1, holderContactNumber);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("the balance of account  is : " + rs.getInt("accountBalance"));
			}
		} catch (SQLException e) {
			System.out.println("Problem while printing balance " + e.getMessage() );
		}
		
	}

	@Override
	public void depositInAccount(Connection dbCon, int transactionAmount) {
		int accountNumber=0;
		Scanner scan = new Scanner(System.in);
		java.util.Date d = new java.util.Date();
		java.sql.Date d1 = new java.sql.Date(d.getTime());
		int ammountDeposit = transactionAmount;
		System.out.println("Enter the depositers contact number");
		double holderContactNumber = scan.nextDouble();
		scan.nextLine();
		String queryDeposit = "insert into transactionDetails(accountNumber,transactionAmount,transactionTime) value (?,?,?)";
		
		String queryGetAccountNumber = "select accountNumber from accountDetails where holderContactNumber =?";
		
		String queryUpdateAccountBalance = "UPDATE accountDetails SET accountBalance = accountBalance + ?  WHERE accountNumber = ?";
											
		try {
			pstmt = dbCon.prepareStatement(queryDeposit);
			pstmt.setInt(2, ammountDeposit);
			pstmt.setDate(3, d1);
			
			pstmt1 = dbCon.prepareStatement(queryGetAccountNumber);
			pstmt1.setDouble(1, holderContactNumber);
			ResultSet rs = pstmt1.executeQuery();
			while(rs.next()) {
				accountNumber = rs.getInt("accountNumber");
			}
			pstmt.setInt(1, accountNumber);
			if(pstmt.executeUpdate()>0)
				System.out.println("Transaction added");
			else
				System.out.println("Transaction not added");
			
			pstmt = dbCon.prepareStatement(queryUpdateAccountBalance);
			pstmt.setInt(1, ammountDeposit);
			pstmt.setInt(2, accountNumber);
			if(pstmt.executeUpdate()>0)
				System.out.println("balance updated");
			else
				System.out.println("balance not updated");
		} catch (SQLException e) {
			System.out.println("Problem while printing balance " + e.getMessage() );
		}
	}

	@Override
	public void withdrawFromAccount(Connection dbCon, int transactionAmountWithdraw) {
		int accountNumber=0;
		Scanner scan = new Scanner(System.in);
		java.util.Date d = new java.util.Date();
		java.sql.Date d1 = new java.sql.Date(d.getTime());
		int ammountDeposit = transactionAmountWithdraw;
		System.out.println("Enter the withdarwer contact number");
		double holderContactNumber = scan.nextDouble();
		scan.nextLine();
		String queryDeposit = "insert into transactionDetails(accountNumber,transactionAmount,transactionTime) values (?,?,?)";
		
		String queryGetAccountNumber = "select accountNumber from accountDetails where holderContactNumber =?";
		
		String queryUpdateAccountBalance = "UPDATE accountDetails SET accountBalance = accountBalance - ? WHERE accountNumber = ?";
		
		String checkBalance = "select accountBalance from accountDetails where accountNumber=?";
											
		try {
			pstmt = dbCon.prepareStatement(queryDeposit);
			pstmt.setInt(2, -ammountDeposit);
			pstmt.setDate(3, d1);
			
			pstmt1 = dbCon.prepareStatement(queryGetAccountNumber);
			pstmt1.setDouble(1, holderContactNumber);
			ResultSet rs = pstmt1.executeQuery();
			while(rs.next()) {
				accountNumber = rs.getInt("accountNumber");
			}
			pstmt.setInt(1, accountNumber);
			if(pstmt.executeUpdate()>0)
				System.out.println("Transaction added");
			else
				System.out.println("Transaction not added");
			
			pstmt = dbCon.prepareStatement(queryUpdateAccountBalance);
			pstmt.setInt(1, ammountDeposit);
			pstmt.setInt(2, accountNumber);
			if(pstmt.executeUpdate()>0)
				System.out.println("balance updated");
			else
				System.out.println("balance not updated");
		} catch (SQLException e) {
			System.out.println("Problem while printing balance " + e.getMessage() );
		}
	}
	
	@Override
	public void fundTransfer(Connection dbCon) {
		int accountNumber = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter transaction amount");
		int transactionAmount = scan.nextInt();
		java.util.Date d = new java.util.Date();
		java.sql.Date d1 = new java.sql.Date(d.getTime());
		System.out.println("Enter the withdarwers contact number");
		double holderContactNumber = scan.nextDouble();
		scan.nextLine();
		String checkBalance = "select accountBalance from accountDetails where accountNumber=?";
		String queryGetAccountNumber = "select accountNumber from accountDetails where holderContactNumber =?";
		
		try {
			pstmt = dbCon.prepareStatement(checkBalance);
			
			pstmt1 = dbCon.prepareStatement(queryGetAccountNumber);
			pstmt1.setDouble(1, holderContactNumber);
			ResultSet rs = pstmt1.executeQuery();
			while(rs.next()) {
				accountNumber = rs.getInt("accountNumber");
			}
			pstmt.setInt(1, accountNumber);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				if(rs.getInt("accountBalance")<transactionAmount)
					throw new  ArithmeticException("not enough balance");
			}
			System.out.println("for withdarwing");
			System.out.println("Enter the account number of withrawer");
			int accountNumberWithdawer = scan.nextInt();
			scan.nextLine();
			String queryWithdraw = "UPDATE accountDetails SET accountBalance = accountBalance - ? WHERE accountNumber = ? ";
			String transactionUpdate = "insert into transactionDetails(accountNumber,transactionAmount,transactionTime) values (?,?,?)";
			pstmt = dbCon.prepareStatement(queryWithdraw);
			pstmt.setInt(1, transactionAmount);
			pstmt.setInt(2,accountNumberWithdawer);
			
			if(pstmt.executeUpdate()>0) {
				System.out.println("balance updated");
				pstmt = dbCon.prepareStatement(transactionUpdate);
				pstmt.setInt(1, accountNumberWithdawer);
				pstmt.setInt(2, -transactionAmount);
				pstmt.setDate(3, d1);
				if(pstmt.executeUpdate()>0)
					System.out.println("trasaction updated");
			}	
			else
				System.out.println("balance not updated");
			
			System.out.println("for receiving");
			System.out.println("Enter the account number of receiver");
			int accountNumberReceiver = scan.nextInt();
			scan.nextLine();
			String queryReceiver = "UPDATE accountDetails SET accountBalance = accountBalance + ? WHERE accountNumber =? ";
			transactionUpdate = "insert into transactionDetails(accountNumber,transactionAmount,transactionTime) values (?,?,?)";
			pstmt1 = dbCon.prepareStatement(queryReceiver);
			pstmt1.setInt(1, transactionAmount);
			pstmt1.setInt(2,accountNumberReceiver);
			
			if(pstmt1.executeUpdate()>0) {
				System.out.println("balance updated");
				pstmt1 = dbCon.prepareStatement(transactionUpdate);
				pstmt1.setInt(1, accountNumberReceiver);
				pstmt1.setInt(2, transactionAmount);
				pstmt1.setDate(3, d1);
				
				if(pstmt1.executeUpdate()>0)
					System.out.println("transaction updated");
			}	
			else
				System.out.println("balance not updated");
				pstmt.close();
				pstmt1.close();
		} catch (SQLException e ) {
			System.out.println("problem while checking balance " + e.getMessage());
		}catch (ArithmeticException e ) {
			System.out.println();
		}
		
		
	}

	@Override
	public void getTransaction(Connection dbCon) {
		String queryGet = "select * from transactionDetails";
		try {
			pstmt = dbCon.prepareStatement(queryGet);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.print("Transaction number is : " + rs.getInt("transcationNumber"));
				System.out.print(",  Account Number is : " + rs.getInt("accountNumber"));
				System.out.print(",  Transaction Amount is : " + rs.getInt("transactionAmount"));
				System.out.println(",  Transaction date is : " + rs.getDate("transactionTime"));
				System.out.println("******************");
				
			}
		} catch (SQLException e) {
			System.out.println("problem while printing transactions "  + e.getMessage());
		}
		
	}
	
	@Override
	public void getAllData(Connection dbCon) {
		String queryGet = "select * from accountDetails";
		try {
			pstmt = dbCon.prepareStatement(queryGet);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.print("Account number is : " + rs.getInt("accountNumber"));
				System.out.print(",  Holder name is  : " + rs.getString("holderName"));
				System.out.print(",  contact number is : " + rs.getDouble("holderContactNumber"));
				System.out.println(",  account balance is : " + rs.getInt("accountBalance"));
				System.out.println("*****************");
			}
		} catch (SQLException e) {
			System.out.println("problem while printing transactions "  + e.getMessage());
		}
		
	}
	
}
