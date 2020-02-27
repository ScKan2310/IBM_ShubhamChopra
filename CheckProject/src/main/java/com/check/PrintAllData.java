package com.check;


public class PrintAllData {
	public PrintAllData(BeanVariable b , WalletSpringServiceClass service) {
		for(BeanVariable val : service.serveGetAllData(b)) {
			System.out.println(val.getAccountNumber());
			System.out.println(val.getHolderName());
			System.out.println(val.getHolderContactNumber());
			System.out.println(val.getAccountBalance());
			System.out.println("***************");
		}
		
	}
}
