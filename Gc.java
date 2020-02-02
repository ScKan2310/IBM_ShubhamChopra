class ElegibilityToDelete
{
	Gc t;
	int var;
	public static void main(String[] args) 
	{
		Gc a = new Gc();
		Gc b = new Gc();
		Gc c = new Gc();
		
		a.t = b;
		b.t = c;
		c.t = a;

		a=null;
		b=null;
		c.t.t.var=40;
		System.out.println("val of var = " + c.t.var);
	}
}