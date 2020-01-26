class Table
{
	public static void main(String[] args) 
	{
		int num = Integer.parseInt(args[0]);
		int limit = Integer.parseInt(args[1]);
		int result=1;

		for(int i=1 ; i<100; i++)
		{

			result = num * i;
			if(result>=limit)
			{
				break;
			}
			System.out.println(num + " * " + i + " = " + result);
			
		}

	}
}