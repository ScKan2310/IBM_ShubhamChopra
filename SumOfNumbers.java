import java.util.Scanner;
class SumOfNumbers
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the limit");
		int num = scan.nextInt();	

		int k = calculateSum(num);
		System.out.println("The sum is : " + k);
	}

	static int calculateSum(int num)
	{
		int sum=0;
		for(int i=0;i<=num;i++)
		{
			if(i%3==0 || i%5==0)
			{
				System.out.println("the number is : " + i);
				sum = sum + i;
			}
		}
		return sum;
	}
}