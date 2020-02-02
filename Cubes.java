import java.util.Scanner;
class Cubes
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number");
		String s = scan.nextLine();

		char []p = s.toCharArray();
		int sum=0;

		for(int i =0; i<p.length; i++)
		{
			int a = Character.getNumericValue(p[i]);

			int cube = a*a*a;
			System.out.println("the no is : " + p[i] + " and the cube is : " + cube);

			sum = sum + cube;
		}
		System.out.println("the sum of cubes is : " + sum);
	}
}