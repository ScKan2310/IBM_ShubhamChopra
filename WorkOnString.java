class WorkOnString
{
	public static void main(String[] args) 
	{
		String s = "JAVA";

		System.out.println(s);

		s += " STRINGS";

		System.out.println(s);

		s = s.concat(" are made for helping");
		System.out.println(s);

		s.toLowerCase();
		System.out.println(s);

		s = s.toUpperCase();
		System.out.println(s);
			
		System.out.println(	s.substring(7) );
		System.out.println(s.substring(3,10));

		System.out.println("The character you want is : " + s.charAt(2) );

		String []token = s.split("A");
		for(String i : token)
		{
			System.out.println(i);
		}
	}
}