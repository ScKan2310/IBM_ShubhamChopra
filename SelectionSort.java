import java.util.Scanner;
class SelectionSort
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);

		int []arr = new int[5];	
		System.out.println("eneter 5 integers : ");
		for(int i=0; i<arr.length;i++)
		{
			arr[i]=scan.nextInt();
		}

		for(int i = 0; i<(arr.length-1); i++)
		{
			for(int j = (i+1); j<arr.length; j++)
			{
				if(arr[i]>arr[j])
				{
					int k;
					k=arr[i];
					arr[i]=arr[j];
					arr[j]=k;
				}
			}
		}
		System.out.println("Sorted array is : ");
		for(int i=0; i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}

	}
}