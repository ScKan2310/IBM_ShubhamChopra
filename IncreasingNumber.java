import java.util.Scanner;
class IncreasingNumber
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);	
		System.out.println("Input the number");
		int num = scan.nextInt();
		if(checkNumber(num))
			System.out.println("yes the number is increasing");
		else
			System.out.println("no the number is not increasing");
	}

	static boolean checkNumber(int num)
	{
		String str = Integer.toString(num);
		char []a = str.toCharArray();
		int []ar = new int[a.length];
		for(int i=0;i<a.length;i++)
		{
			ar[i] = Character.getNumericValue(a[i]);
		}
		int flag=0;
		for(int i=0;i<(a.length-1);i++)
		{
			if(a[i]<a[i+1])
				flag = flag+1;
			else
				break;
		}

		if(flag == (a.length-1))
			return true;
		else
			return false;
	}
}