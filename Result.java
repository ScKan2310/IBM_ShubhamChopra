class Result
{
	public static void main(String[] args) 
	{
		int num1 = Integer.parseInt(args[0]);	
		int num2 = Integer.parseInt(args[1]);	
		int num3 = Integer.parseInt(args[2]);	
		int sum = num1 + num2 + num3;
		
		int flag = 0;

		if(num1>=40)
		{
			flag=flag+1;
		}
		if(num2>=40)
		{
			flag=flag+1;
		}
		if(num3>=40)
		{
			flag=flag+1;
		}
		if(sum>=125)
		{
			flag=flag+1;
		}
		if(flag==4)
		{
			System.out.println("Passing");
		}
		if(flag!=4)
		{
			System.out.println("Failing");
		}

	}
}
