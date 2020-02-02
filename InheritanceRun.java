class Human
{
	final void breathe()
	{
		System.out.println("breathe");
	}

	void eat()
	{
		System.out.println("eat");
	}

	void sleep()
	{
		System.out.println("sleep");
	}
}

class Shubham extends Human
{
	@Override
	void eat()
	{
		System.out.println("Shubham eat");
	}

	void run()
	{
		System.out.println("Shubham Run");
	}

	void sleep(int k)
	{
		System.out.println("Shubham sleeps for " + k + " hours");
	}
}

class Ansh extends Human
{
	
	//void breathe()
	//{
	//	System.out.println("Ansh is superhuman");
	//}

	void sleep(int k)
	{
		System.out.println("Shubham sleeps for " + k + " hours");
	}
}

class InheritanceRun
{
	public static void main(String[] args) 
	{
		Shubham sh = new Shubham();
		Ansh a = new Ansh();
		sh.eat();

		a.breathe();
		Human h = new Human();

		h.eat();

		sh.sleep();
		sh.sleep(9);

		a.sleep();
		a.sleep(12);
	}
}