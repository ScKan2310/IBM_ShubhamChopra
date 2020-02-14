package com.wallet.dao;

import java.sql.Connection;

public interface WalletDaoInterface {
	
	void insertData(Connection dbCon);
	void updateData(Connection dbCon);
	void getBalance(Connection dbCon);
	void depositInAccount(Connection dbCon, int transactionAmount);
	void withdrawFromAccount(Connection dbCon, int transactionAmount);
	void fundTransfer(Connection dbCon);
	void getTransaction(Connection dbCon);
	void getAllData(Connection dbCon);
}
