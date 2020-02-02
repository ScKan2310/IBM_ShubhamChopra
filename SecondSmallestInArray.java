import java.util.Scanner;
class SecondSmallestInArray
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the size of the array");
		int size = scan.nextInt();
		int []ar = new int[size];	
		System.out.println("Enter the elements of array with spaces");
		for(int i=0; i<size; i++)
		{
			ar[i]=scan.nextInt(); 
		}

		int k = findSecondSmallest(ar);
		System.out.println("the second smallestr no. is : " + k);

	}

	public static int findSecondSmallest(int [] ar)
	{
		for(int i = 0; i<(ar.length-1); i++)
		{
			for(int j = (i+1); j<ar.length; j++)
			{
				if(ar[i]>ar[j])
				{
					int k;
					k=ar[i];
					ar[i]=ar[j];
					ar[j]=k;
				}
			}
		}
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the ___ smallest number you want in a number format");
		int n = scan.nextInt();
		return ar[n-1];
	}
}