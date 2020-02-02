import java.util.Scanner;
class RewriteBuffer
{	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the string ");
		StringBuffer s =  new StringBuffer(scan.nextLine());
		
		System.out.println(s);

		System.out.println("Enter the change you want in the string ");
		String s1 = scan.nextLine();

		// s = new StringBuffer(s1);
		// System.out.println("the changed string as a buffer is: ");
		// System.out.println(s1);

		s = s.replace(0, s.length(), s1);
		System.out.println(s);
	}
	
}