import java.util.Scanner;
class UserDefinedException extends Exception
{
	void UserDefinedException()
	{
		System.out.println("age cannot be below 15");
	}
}


class ValidateAge
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the age");
		int n = scan.nextInt();
		try{
			if(n<15)
				throw new UserDefinedException();	
		}catch(UserDefinedException e){
			e.UserDefinedException();
		}
	}
}