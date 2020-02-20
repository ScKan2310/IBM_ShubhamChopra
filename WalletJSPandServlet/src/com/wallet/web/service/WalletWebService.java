package com.wallet.web.service;

import java.util.List;

import com.wallet.web.bean.Bean;

public interface WalletWebService {
	int serveInsert(Bean b);
	int serveUpdateName(Bean b);
	int serveUpdateNumber(Bean b);
	Bean serveGetBalance(Bean b);
	int serveDepositInAccount(Bean b);
	int serveWithdrawFromAccount(Bean b);
	List<Bean> serveGetTransaction(Bean b);
	List<Bean> serveGetAllData(Bean b);
	int serveCheckPassword(Bean b);
}
