import java.util.Scanner;
class PrintPrimeNumbers
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("enter the number");
		int num = scan.nextInt();
		int temp=0;

		for(int i = 0; i<=num; i++)
		{
			int flag = 0;
			for(int j = 2 ; j<=(i/2); j++)
			{
				temp = i%j;
				if(temp==0)
				{
					flag =1;
					break;
				}
			}
		if(flag==0)
			System.out.println(i);
		}	
	}
}