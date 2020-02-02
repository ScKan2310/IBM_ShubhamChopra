import java.util.Scanner;
class ReverseAndSort
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the size of teh array");
		int size = scan.nextInt();

		int []ar = new int[size];
		System.out.println("Enter the array elements");
		for(int i=0; i<size;i++)
		{
			ar[i] = scan.nextInt();
		}
		int []a	= revandso(ar);


		System.out.println("The reversed and sorted array is");
		for(int i=0;i<a.length;i++)
		{
			System.out.println(a[i]);
		}


	}

	public static int[] revandso(int [] ar)
	{
		StringBuilder []st = new StringBuilder[ar.length];
		for(int i=0;i<ar.length;i++)
		{
			//str[i] = Integer.toString(ar[i]);
			st[i] = st[i].append(Integer.toString(ar[i]));
			st[i] = st[i].reverse();
			//System.out.println(st[i]);
			ar[i] = Integer.parseInt(st[i].toString());
		}

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

		return ar;


	}
}