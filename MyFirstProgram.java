class Factorial
{
	public static void main(String[] args) 
	{
		int num;
		num = Integer.parseInt(args[0]);
		int constant=num;
		for(int i = (num-1) ; i>0 ; i--)
		{
			constant = i * constant;
		}
	}
}