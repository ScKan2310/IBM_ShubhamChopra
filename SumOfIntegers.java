import java.util.*;
class SumOfIntegers
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the ineger nos with spaces");
		String s = scan.nextLine();
		StringTokenizer str = new StringTokenizer(s," ");

		int sum=0;
		while(str.hasMoreTokens())
		{
			int i = Integer.parseInt(str.nextToken());
			System.out.println("The token is " + i);
			
			sum = sum+i;

		}

		System.out.println("the sum of nos is : " + sum);

	}
}