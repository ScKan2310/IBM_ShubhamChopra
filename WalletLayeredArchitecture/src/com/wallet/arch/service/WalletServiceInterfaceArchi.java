package com.wallet.arch.service;

import java.sql.ResultSet;
import java.util.List;

import com.wallet.arch.bean.Bean;

public interface WalletServiceInterfaceArchi {
	int serveInsert(Bean b);
	int serveUpdateName(Bean b);
	int serveUpdateNumber(Bean b);
	Bean serveGetBalance(Bean b);
	int serveDepositInAccount(Bean b);
	int serveWithdrawFromAccount(Bean b);
	List<Bean> serveGetTransaction(Bean b);
	List<Bean> serveGetAllData(Bean b);
}
