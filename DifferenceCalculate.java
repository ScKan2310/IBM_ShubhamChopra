import java.util.Scanner;
class DifferenceCalculate
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the limit");
		int num = scan.nextInt();	

		int k = calculateDifference(num);
		System.out.println("The Difference between sum of squares and square of sum  is : " + k);
	}

	static int calculateDifference(int num)
	{
		int sum1=0;
		int sum2=0;
		for(int i=1;i<=num;i++)
		{

			sum1=sum1 + i*i;
			sum2 = sum2 + i;
			System.out.println("the no is ----- " + i + "  the sum of squares is ---- " + sum1 + "  the sum of nos is ---- " + sum2);
		}
		sum2=sum2*sum2;
		System.out.println("The square of the sum is " + sum2);

		return (sum1-sum2);
	}
}