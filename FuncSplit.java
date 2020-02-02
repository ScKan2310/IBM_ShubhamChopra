import java.util.Scanner;
class FuncSplit
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the String");
		String s = scan.nextLine();
		char []f = s.toCharArray();	
		char []g = new char[f.length];

		System.out.println("Enter the char to check");
		char check = scan.next().charAt(0);
		int k = 0;
		
		for(int i=0; i<f.length;i++)
		{
			if(f[i] == check)
			{
				k++;
			}
		}
		String []str = new String[k]; 
		int l=0;
		int j=0;

		for(int i =0 ; i<f.length ; i++)
		{
			g[j]=f[i];
			j++;
			if(f[i]==check)
			{
				str[l] = String.valueOf(g);
				l++;
				g.delete(0,g.length);
				j=0; 
			}

			
		}

		for(int i =0 ; i<str.length ; i++)
		{
			System.out.println(str[i]);
		}
	}
}