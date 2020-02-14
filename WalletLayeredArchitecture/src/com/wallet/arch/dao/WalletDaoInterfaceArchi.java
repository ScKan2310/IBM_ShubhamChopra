package com.wallet.arch.dao;

import java.sql.ResultSet;
import java.util.List;

import com.wallet.arch.bean.Bean;

public interface WalletDaoInterfaceArchi {
	int insertData(Bean b);
	int updateName(Bean b);
	int updateNumber(Bean b);
	Bean getBalance(Bean b);
	boolean checkBalance(Bean b);
	int depositInAccount(Bean b);
	int withdrawFromAccount(Bean b);
	List<Bean> getTransaction(Bean b);
	List<Bean> getAllData(Bean b);
}
