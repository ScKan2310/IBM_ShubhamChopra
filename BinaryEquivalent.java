class BinaryEquivalent
{
	public static void main(String[] args) 
	{
		int num = Integer.parseInt(args[0]);
		int result;
		System.out.println("The binary equivalent of the number is:  ");
		for( int i=num ; i>0 ; )
		{
			result= i  % 2;
			i=i/2;
			System.out.print(result + " ");
		}
	}
}