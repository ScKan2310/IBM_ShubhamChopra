package com.wallet.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.wallet.web.bean.Bean;
import com.wallet.web.ui.PrintException;

public class WalletWebDao implements WalletWebDaoInterface {

	Connection dbCon;
	PreparedStatement pstmt;
	PreparedStatement pstmt1;
	
	public WalletWebDao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/wallet?serverTimezone=UTC", "root", "");
		} catch (SQLException e) {
			Bean b = new Bean();
			b.setException(e.getMessage());
			PrintException.problemConnection(b);
		}catch(ClassNotFoundException e) {
			Bean b = new Bean();
			b.setException(e.getMessage());
			PrintException.problemClass(b);
		}
	}
	
	@Override
	public int insertData(Bean b) {
		int n=0;
		String insertQuery = "insert into accountdetails values(?,?,?,?)";
		String loginQuery = "insert into logindetails values(?,?)";
		try {
			pstmt = dbCon.prepareStatement(insertQuery);
			pstmt.setString(2, b.getHolderName());
			pstmt.setDouble(3, b.getHolderContactNumber());
			pstmt.setInt(4, b.getAccountBalance());
			pstmt.setInt(1, b.getAccountNumber());
			
			if(pstmt.executeUpdate()>0)
				n=n+1;	
			pstmt = dbCon.prepareStatement(loginQuery);
			pstmt.setDouble(1, b.getHolderContactNumber());
			pstmt.setString(2, b.getPassWord());
			
			if(pstmt.executeUpdate()>0)
				n=n+1;
		} catch (SQLException e) {
			b.setException(e.getMessage());
			PrintException.problemInserting(b);
		}
		return n;
	}
	
	@Override
	public int updateName(Bean b) {
		int n=0;
		String queryNameUpdate = "update accountdetails set holderName = ? where accountNumber =?";
		try {
			pstmt = dbCon.prepareStatement(queryNameUpdate);
			pstmt.setInt(2,b.getAccountNumber());
			pstmt.setString(1,b.getHolderName());
			
			if(pstmt.executeUpdate()>0)
				n=n+1;
		} catch (SQLException e) {
			b.setException(e.getMessage());
			PrintException.problemUpdatingName(b);
		}
		return n;
	}

	@Override
	public int updateNumber(Bean b) {
		int n=0;
		String queryNumberUpdate = "update accountdetails set holderContactNumber = ? where accountNumber =?";
		try {
			pstmt = dbCon.prepareStatement(queryNumberUpdate);
			pstmt.setInt(2,b.getAccountNumber());
			pstmt.setDouble(1,b.getHolderContactNumber());
			
			if(pstmt.executeUpdate()>0)
				n=n+1;
		} catch (SQLException e) {
			b.setException(e.getMessage());
			PrintException.problemUpdatingNumber(b);
		}
		return n;
	}

	@Override
	public Bean getBalance(Bean b) {
		String queryGetBalance = " select accountBalance from accountdetails where holderContactNumber = ?";
		
		try {
			pstmt = dbCon.prepareStatement(queryGetBalance);
			pstmt.setDouble(1, b.getHolderContactNumber());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
				b.setAccountBalance(rs.getInt("accountBalance"));
		} catch (SQLException e) {
			b.setException(e.getMessage());
			PrintException.problemGettingBalance(b);
		}
		return b;
	}

	public boolean checkBalance(Bean b) {
		boolean t = false;
		String checkBalance = "select accountBalance from accountdetails where accountNumber=?";
		String queryGetAccountNumber = "select accountNumber from accountdetails where holderContactNumber =?";
		try {
			pstmt = dbCon.prepareStatement(checkBalance);
			
			pstmt1 = dbCon.prepareStatement(queryGetAccountNumber);
			pstmt1.setDouble(1, b.getHolderContactNumber());
			ResultSet rs = pstmt1.executeQuery();
			while(rs.next()) {
				b.setAccountNumber(rs.getInt("accountNumber"));
			}
			pstmt.setInt(1, b.getAccountNumber());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getInt("accountBalance")>b.getTransctionAmount())
					t = true;
			}
		} catch (SQLException e ) {
			b.setException(e.getMessage());
			PrintException.problemCheckingBalance(b);
		}
		return t;
		
	}
	
	@Override
	public int depositInAccount(Bean b) {
		int flag=0;
		String queryDeposit = "insert into transactiondetails(accountNumber,transactionAmount,transactionTime) value (?,?,?)";
		
		String queryGetAccountNumber = "select accountNumber from accountdetails where holderContactNumber =?";
		
		String queryUpdateAccountBalance = "UPDATE accountdetails SET accountBalance = accountBalance + ?  WHERE accountNumber = ?";
											
		try {
			pstmt = dbCon.prepareStatement(queryDeposit);
			pstmt.setInt(2, b.getTransctionAmount());
			pstmt.setDate(3, b.getTransactionTime());
			
			pstmt1 = dbCon.prepareStatement(queryGetAccountNumber);
			pstmt1.setDouble(1, b.getHolderContactNumber());
			ResultSet rs = pstmt1.executeQuery();
			if(rs.next()) {
				b.setAccountNumber(rs.getInt("accountNumber"));
			}
			pstmt.setInt(1, b.getAccountNumber());
			if(pstmt.executeUpdate()>0)
				flag=flag+1;
			
			pstmt = dbCon.prepareStatement(queryUpdateAccountBalance);
			pstmt.setInt(1, b.getTransctionAmount());
			pstmt.setInt(2, b.getAccountNumber());
			if(pstmt.executeUpdate()>0)
				flag=flag+1;
		} catch (SQLException e) {
			b.setException(e.getMessage());
			PrintException.problemDepositing(b);
		}
		return flag;
	}

	public int withdrawFromAccount(Bean b) {
		int flag=0;
		String queryDeposit = "insert into transactiondetails(accountNumber,transactionAmount,transactionTime) value (?,?,?)";
		
		String queryGetAccountNumber = "select accountNumber from accountdetails where holderContactNumber =?";
		
		String queryUpdateAccountBalance = "UPDATE accountdetails SET accountBalance = accountBalance - ?  WHERE accountNumber = ?";
		if(checkBalance(b)) {								
		try {
			pstmt = dbCon.prepareStatement(queryDeposit);
			pstmt.setInt(2, -b.getTransctionAmount());
			pstmt.setDate(3, b.getTransactionTime());
			
			pstmt1 = dbCon.prepareStatement(queryGetAccountNumber);
			pstmt1.setDouble(1, b.getHolderContactNumber());
			ResultSet rs = pstmt1.executeQuery();
			if(rs.next()) {
				b.setAccountNumber(rs.getInt("accountNumber"));
			}
			pstmt.setInt(1, b.getAccountNumber());
			if(pstmt.executeUpdate()>0)
				flag=flag+1;
			
			pstmt = dbCon.prepareStatement(queryUpdateAccountBalance);
			pstmt.setInt(1, b.getTransctionAmount());
			pstmt.setInt(2, b.getAccountNumber());
			if(pstmt.executeUpdate()>0)
				flag=flag+1;
		} catch (SQLException e) {
			b.setException(e.getMessage());
			PrintException.problemWithdrawing(b);
		}
		}
		else
			PrintException.printNoFunds(b);
		
		return flag;
	}

	public List<Bean> getTransaction(Bean b) {
		List<Bean> bilers = new ArrayList<Bean>();
		String queryGet = "select * from transactionDetails";
		try {
			pstmt = dbCon.prepareStatement(queryGet);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Bean b1 = new Bean();
				b1.setTransactionNumber(rs.getInt("transcationNumber"));
				b1.setAccountNumber(rs.getInt("accountNumber"));
				b1.setTransctionAmount(rs.getInt("transactionAmount"));
				b1.setTransactionTime(rs.getDate("transactionTime"));
				bilers.add(b1);
			}
		} catch (SQLException e) {
			b.setException(e.getMessage());
			PrintException.problemPrintingTransaction(b);
		}
		return bilers ;
	}
	
	public List<Bean> getAllData(Bean b) {
		List<Bean> bilers = new ArrayList<Bean>();
		String queryGet = "select * from accountDetails";
		try {
			pstmt = dbCon.prepareStatement(queryGet);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Bean b1 = new Bean();
				b1.setAccountNumber(rs.getInt("accountNumber"));
				b1.setHolderName(rs.getString("holderName"));
				b1.setHolderContactNumber(rs.getDouble("holderContactNumber"));
				b1.setAccountBalance(rs.getInt("accountBalance"));
				bilers.add(b1);
			}
		} catch (SQLException e) {
			b.setException(e.getMessage());
			PrintException.problemPrintingData(b);
		}
		return bilers;
	}

	@Override
	public int checkPassword(Bean b) {
		int n=0;
		int m=0;
		String checkQuery = "select holderContactNumber from logindetails";
		String checkPassWord = "select passWord from logindetails where holderContactNumber=?";
		try {
			pstmt = dbCon.prepareStatement(checkQuery);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				if(b.getHolderContactNumber()==rs.getDouble("holderContactNumber")) {
					n=n+1;
					m=m+1;
				}
			}
			pstmt = dbCon.prepareStatement(checkPassWord);
			pstmt.setDouble(1, b.getHolderContactNumber());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				if(b.getPassWord().trim().equals(rs.getString("passWord")))
					n=n+1;
			}
			
		} catch (SQLException e) {
			System.out.println("Problem while checking" + e.getMessage());
		}
		return n;
	}
}


