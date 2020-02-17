package com.wallet.arch.service;

import java.util.List;

import com.wallet.arch.bean.Bean;
import com.wallet.arch.dao.WalletDaoArchi;

public class WalletServiceArchi implements WalletServiceInterfaceArchi {
	WalletDaoArchi d = new WalletDaoArchi();
	@Override
	public int serveInsert(Bean b) {
		return d.insertData(b);
	}
	
	@Override
	public int serveUpdateName(Bean b) {
	 return d.updateName(b);	
	}
	
	@Override
	public int serveUpdateNumber(Bean b) {
	 return d.updateNumber(b);	
	}
	
	@Override
	public Bean serveGetBalance(Bean b) {
		return d.getBalance(b);
	}
	
	@Override
	public int serveDepositInAccount(Bean b) {
		return d.depositInAccount(b);
	}
	
	@Override
	public int serveWithdrawFromAccount(Bean b) {
		return d.withdrawFromAccount(b);
	}

	public List<Bean> serveGetTransaction(Bean b) {
		return d.getTransaction(b);
	}
	
	@Override
	public List<Bean> serveGetAllData(Bean b) {
		return d.getAllData(b);
	}
}

