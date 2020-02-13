package com.eis.ui;
import java.sql.Connection;
import java.util.Scanner;

import com.eis.service.ServiceForEmployee;
public class UserInteraction {
	static Connection dbCon;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ServiceForEmployee service = new ServiceForEmployee();
		dbCon = service.ServiceConnection(dbCon);
		while(true) {
			System.out.println("************************************************************");
			System.out.println("Press 1 for inserting new employee details");
			System.out.println("Press 2 for updating employee details");
			System.out.println("Press 3 for deleting new employee details");
			System.out.println("Press 4 for displaying new employee details");
			int n = scan.nextInt();
			switch(n) {
			case 1: 
				service.insertData(dbCon);
				break;
			case 2:
				service.updateData(dbCon);
				break;
			case 3:
				service.deleteData(dbCon);
				break;
			case 4:
				service.getData(dbCon);
				break;
			}
			
			System.out.println("If to want to go out of the database press 0 else Press 1");
			int m = scan.nextInt();
			scan.nextLine();
			if(m==0)
				break;
		}
	}

}
