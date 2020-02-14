package com.wallet.service;

import java.sql.Connection;

public interface WalletServiceInterface {
	Connection runDao();
	public void extractFunctinsOfDao(int n);
}
