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
		int temp = i.intValue();
		temp++;
		System.out.println("the increment is shown below");
		System.out.println(temp);
		i = new Integer(temp);
		
		System.out.println("enter the first no");
		int a = scan.nextInt();
		
		System.out.println("enter the second no");
		int b = scan.nextInt();
	
		int sum = i.sum(a,b);
		System.out.println("the sum of two nos you enetred is:");
		System.out.println(sum);
		
		int maximum = i.max(a,b);
		System.out.println("the max of two nos you enetred is:");
		System.out.println(maximum);

		int comp = i.compare(a,b);
		if(comp<0)
			System.out.println("the larges number is : " + b);
		else if(comp==0)
			System.out.println("the numbers are equal");
		else 
			System.out.println("the larges number is : " + a);
		
	}
}