package com.check;



public class PrintAllTransactionSpringUI {
	public PrintAllTransactionSpringUI(BeanVariable b, WalletSpringServiceClass service) {
		for(BeanVariable val : service.serveGetTransaction(b)) {
			System.out.println(val.getTransactionNumber());
			System.out.println(val.getAccountNumber());
			System.out.println(val.getTransctionAmount());
			System.out.println(val.getTransactionTime());
			System.out.println("***************");
		}
	}
}
