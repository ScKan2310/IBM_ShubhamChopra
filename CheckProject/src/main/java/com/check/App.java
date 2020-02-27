package com.check;

import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("contextFile.xml");
    	
    	Scanner scan = new Scanner(System.in);
		BeanVariable b = context.getBean("beanclass",BeanVariable.class);
		WalletSpringServiceClass service = context.getBean("serviceclass", WalletSpringServiceClass.class);
		
		while(true) {
			System.out.println("Press 1 for inserting a new customer");
			System.out.println("Press 2 for updating an existing customer name");
			System.out.println("Press 3 for updating an existing customer number");
			System.out.println("Press 4 for deposit any amount");
			System.out.println("Press 5 for withdrawing any amount");
			System.out.println("Press 6 for tranfering funds");
			System.out.println("Press 7 for printing balance of the account");
			System.out.println("Press 8 for printig all transactions");
			System.out.println("Press 9 for printing accountdetails of all customers");
			System.out.println("Press 10 for halting");
			int n = scan.nextInt();
			scan.nextLine();
			switch(n) {
			case 1:
				new InsertSpringUI(b,service); 
				break;
			case 2:
				new UpdateNameSpringUI(b, service);
				break;
			case 3:
				new UpdateNumberSpringUI(b, service);
				break;
			case 4:
				new DepositFundsSpringUI(b, service);
				break;
			case 5: 
				new WithdrawFundsSpringUI(b, service);
				break;
			case 6:
				new FundTransferSpringUI(b, service);
				break;
			case 7:
				new PrintBalanceSpringUI(b, service);
				break;
			case 8:
				new PrintAllTransactionSpringUI(b, service);
				break;
			case 9:
				new PrintAllData(b, service);
				break;
			case 10:
				n=11;
				break;
			default:
				break;
			}
			if(n==11)
				break;
		}

    }
}
