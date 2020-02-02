import java.util.Scanner;
class Awrapper
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("enter a string");
		String s;
		s = scan.nextLine(); 
		Integer i = new Integer(s);
		i++;
		System.out.println(i);
	}
}