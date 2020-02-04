import java.util.Scanner;
class UserDefinedException extends Exception
{
	void UserDefinedException()
	{
		System.out.println("Enter the name , it cannot be left blank");
	}
}


class ValidateFullName
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter First Name");

		String firstName = scan.nextLine();

		// System.out.println("#" + firstName.length() + "#");

		System.out.println("Enter Last Name");
		
		String lastName = scan.nextLine();	
		try{
			if(firstName.length() == 0)
				throw new UserDefinedException();
			System.out.println(firstName);

			if(lastName.length() == 0)
				throw new UserDefinedException();
			System.out.print(lastName);
		}catch(UserDefinedException e){
			e.UserDefinedException();
		}
		
	}
}