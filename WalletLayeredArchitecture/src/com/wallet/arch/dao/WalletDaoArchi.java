package com.wallet.arch.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wallet.arch.bean.Bean;
import com.wallet.arch.ui.WalletUIArchi;

public class WalletDaoArchi implements WalletDaoInterfaceArchi {
	Connection dbCon;
	PreparedStatement pstmt;
	PreparedStatement pstmt1;
	
	public WalletDaoArchi() {
		try {
			dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/wallet?serverTimezone=UTC", "root", "");
		} catch (SQLException e) {
			Bean b = new Bean();
			b.setException(e.getMessage());
			WalletUIArchi.problemConnection(b);
		}
	}
	
	public int insertData(Bean b) {
		int n=0;
		String insertQuery = "insert into accountDetails values(?,?,?,?)";
		try {
			pstmt = dbCon.prepareStatement(insertQuery);
			pstmt.setString(2, b.getHolderName());
			pstmt.setDouble(3, b.getHolderContactNumber());
			pstmt.setInt(4, b.getAccountBalance());
			pstmt.setInt(1, b.getAccountNumber());
			
			if(pstmt.executeUpdate()>0)
				n=n+1;	
		} catch (SQLException e) {
			b.setException(e.getMessage());
			WalletUIArchi.problemInserting(b);
		}
		return n;
	}
	
	@Override
	public int updateName(Bean b) {
		int n=0;
		String queryNameUpdate = "update accountDetails set holderName = ? where accountNumber =?";
		try {
			pstmt = dbCon.prepareStatement(queryNameUpdate);
			pstmt.setInt(2,b.getAccountNumber());
			pstmt.setString(1,b.getHolderName());
			
			if(pstmt.executeUpdate()>0)
				n=n+1;
		} catch (SQLException e) {
			b.setException(e.getMessage());
			WalletUIArchi.problemUpdatingName(b);
		}
		return n;
	}

	@Override
	public int updateNumber(Bean b) {
		int n=0;
		String queryNumberUpdate = "update accountDetails set holderContactNumber = ? where accountNumber =?";
		try {
			pstmt = dbCon.prepareStatement(queryNumberUpdate);
			pstmt.setInt(2,b.getAccountNumber());
			pstmt.setDouble(1,b.getHolderContactNumber());
			
			if(pstmt.executeUpdate()>0)
				n=n+1;
		} catch (SQLException e) {
			b.setException(e.getMessage());
			WalletUIArchi.problemUpdatingNumber(b);
		}
		return n;
	}

	@Override
	public Bean getBalance(Bean b) {
		String queryGetBalance = " select accountBalance from accountDetails where holderContactNumber = ?";
		
		try {
			pstmt = dbCon.prepareStatement(queryGetBalance);
			pstmt.setDouble(1, b.getHolderContactNumber());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
				b.setAccountBalance(rs.getInt("accountBalance"));
		} catch (SQLException e) {
			b.setException(e.getMessage());
			WalletUIArchi.problemGettingBalance(b);
		}
		return b;
	}

	public boolean checkBalance(Bean b) {
		boolean t = false;
		String checkBalance = "select accountBalance from accountDetails where accountNumber=?";
		String queryGetAccountNumber = "select accountNumber from accountDetails where holderContactNumber =?";
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
			WalletUIArchi.problemCheckingBalance(b);
		}
		return t;
		
	}
	
	@Override
	public int depositInAccount(Bean b) {
		int flag=0;
		String queryDeposit = "insert into transactionDetails(accountNumber,transactionAmount,transactionTime) value (?,?,?)";
		
		String queryGetAccountNumber = "select accountNumber from accountDetails where holderContactNumber =?";
		
		String queryUpdateAccountBalance = "UPDATE accountDetails SET accountBalance = accountBalance + ?  WHERE accountNumber = ?";
											
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
			WalletUIArchi.problemDepositing(b);
		}
		return flag;
	}

	public int withdrawFromAccount(Bean b) {
		int flag=0;
		String queryDeposit = "insert into transactionDetails(accountNumber,transactionAmount,transactionTime) value (?,?,?)";
		
		String queryGetAccountNumber = "select accountNumber from accountDetails where holderContactNumber =?";
		
		String queryUpdateAccountBalance = "UPDATE accountDetails SET accountBalance = accountBalance - ?  WHERE accountNumber = ?";
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
			WalletUIArchi.problemWithdrawing(b);
		}
		}
		else
			WalletUIArchi.printNoFunds(b);
		
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
			WalletUIArchi.problemPrintingTransaction(b);
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
			WalletUIArchi.problemPrintingData(b);
		}
		return bilers;
	}
}
