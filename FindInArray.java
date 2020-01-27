import java.util.Scanner;
class FindInArray
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);

		int []arr = new int[10];
		System.out.println("eneter 10 values: ");
		for(int i=0; i<arr.length;i++)
		{
			arr[i]=scan.nextInt();
		}

		System.out.println("enetr the value you need: ");

		int num, flag=0;
		num= scan.nextInt();
		for(int val = 0; val<arr.length; val++)
		{
			if(arr[val]==num)
			{
				System.out.println("the index of num in the array is :  " + val);
				flag=1;
				break;
			}	
		}	

		if(flag==0)
		{
			System.out.println("number not found");
		}

	}
}