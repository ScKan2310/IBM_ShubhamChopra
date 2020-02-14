package com.wallet.arch.ui;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.wallet.arch.bean.Bean;
import com.wallet.arch.service.WalletServiceArchi;

public class PrintAllTransactionUI {

	public PrintAllTransactionUI(Bean b, WalletServiceArchi service) {
		List<Bean> bilers = service.serveGetTransaction(b);
		for(Bean val : bilers) {
			System.out.println(val);
			System.out.println("***************");
		}
		}
}


