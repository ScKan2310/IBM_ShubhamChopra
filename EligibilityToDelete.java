class EligibilityToDelete
{
	EligibilityToDelete t;
	int var;
	public static void main(String[] args) 
	{
		EligibilityToDelete a = new EligibilityToDelete();
		EligibilityToDelete b = new EligibilityToDelete();
		EligibilityToDelete c = new EligibilityToDelete();
		
		a.t = b;
		b.t = c;
		c.t = a;

		a=null;
		b=null;
		c.t.t.var=40;
		System.out.println("val of var = " + c.t.t.var);
	}
}

