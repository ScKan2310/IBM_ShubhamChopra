import java.util.Scanner;
class WorkOnStringBuffer
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the string to check for PALENDROME");
		String buffer = new String(scan.nextLine());
		StringBuffer check = new StringBuffer(buffer).reverse();
		String check1 = check.toString();
		//System.out.println(check1);
		if(buffer.equals(check1))
			System.out.println("it is PALENDROME");
		else
			System.out.println("not a PALNEDROME");
	 }
}