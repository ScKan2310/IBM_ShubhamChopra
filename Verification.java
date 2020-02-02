import java.util.Scanner;

class Verification
{
	public static void main(String[] args) 
	{
		
		while(true)
		{
			Scanner scan = new Scanner(System.in);

			System.out.println("Input Username");

			String s = scan.nextLine();
			int flag = 0;
			int n = s.length();
			if(n>=12)
			{
				Verification v = new Verification();
				char []p = s.toCharArray();

				if(p[n-1]=='b' && p[n-2]=='o' && p[n-3]=='j' && p[n-4]=='_')
					{
						System.out.println("True");
						break;
					}
				else
					System.out.println("False");
			}
			else
				{
					System.out.println("enter a valid username");
				}
		}
	}

}

