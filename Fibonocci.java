class Fibonocci
{
	public static void main(String[] args) 
	{
		int a=1;
		int b=1;
		for(int i=1 ; i<89 ; i++)
		{
			System.out.println(b);
			b=a+b;
			a=b-a;	
			if(b>89)
			{
				break;
			}
		}
	}	
}