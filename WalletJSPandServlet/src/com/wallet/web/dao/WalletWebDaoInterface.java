package com.wallet.web.dao;

import java.util.List;

import com.wallet.web.bean.Bean;

public interface WalletWebDaoInterface {
	
	int insertData(Bean b);
	int updateName(Bean b);
	int updateNumber(Bean b);
	Bean getBalance(Bean b);
	boolean checkBalance(Bean b);
	int depositInAccount(Bean b);
	int withdrawFromAccount(Bean b);
	List<Bean> getTransaction(Bean b);
	List<Bean> getAllData(Bean b);
	int checkPassword(Bean b);
}
