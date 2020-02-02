import java.util.Scanner;
class CharFind
{
	public static void main(String[] args) 
	{
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter the String");
			String s = scan.nextLine();
			char []f = s.toCharArray();
			
			System.out.println("Enter the char to check");
			char check = scan.next().charAt(0);
			int k=0;
			int count = 0;
			for(int i =0 ; i<f.length; i++)
			{
				if(f[i] == check)
				{
					k=i;
					System.out.println("the char is at " + k + " and");  
					count = count + 1;
				}
			}

			System.out .println("It appears " + count + " times ");


	}
}