import java.util.Scanner;
class FibonocciUserInput
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int a=1;
		int b=1;
		System.out.println("Enter the number you want till the Fibonocci to end");
		int num = scan.nextInt();
		for(int i=1 ; i<num ; i++)
		{
			System.out.println(b);
			b=a+b;
			a=b-a;	
			if(b>num)
			{
				break;
			}
		}
	}	
}