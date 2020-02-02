import java.util.*;
import java.text.SimpleDateFormat;
class FindDate
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Input the date");
		String d = scan.nextLine();
		SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
		Date d1 = new Date();
		System.out.println(d1);
		Date d2 = null;
		// d2 = format.parse(d);

		// int i = d1.compareTo(d2);
		// if(i==0)
		// 	System.out.println("the dates are equal");
		// else if (i<0)
		// 	System.out.println("the given date is larger");
		// else 
		// 	System.out.println("the current date is larger");	


		
	}
}