import java.util.Scanner;
class PositiveString
{
	public static void main(String[] args)
	{
			PositiveString p1 = new PositiveString();
			p1.Positive();
			
	}

	void Positive()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the string");
		String s = scan.nextLine();
		char []st = s.toCharArray();
		int n= st.length;
		System.out.println(n);
		int flag = 0;
		for(int i=0 ; i<(st.length-1) ; i++ )
		{
			int a = st[i];
			int b = st[i+1];
			if(a<b)
			flag = flag + 1;
			else
				break;
		}
		System.out.println("the result for checking for positive string is");
		if(flag==(st.length-1))
			System.out.println("Positive String");
		else
			System.out.println("Negative String");
	}

}