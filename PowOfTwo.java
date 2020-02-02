import java.util.*;
class PowOfTwo
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("enter the number");
		int num = scan.nextInt();	
		
		if(checkNumber(num))
			System.out.println("the number is a power of two");
		else
			System.out.println("the number is not a power of two");
	}

	static boolean checkNumber(int num)
	{
		double x = Math.log10(num)/Math.log10(2);
		if(x-(int)x == 0)
			return true;
		else
			return false;
	}
}