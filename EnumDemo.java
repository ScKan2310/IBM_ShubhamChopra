enum PizzaSize
{
	SMALL(2), MEDIUM(3), LARGE(4), XLARGE(6);
	private int serving;
	PizzaSize(int serving)
	{
		this.serving = serving;
	}

	public int getServing()
	{
		return this.serving;
	}
}

enum PizzaType
{
	VEG(9), NONVEG(16);
	private int options;
	PizzaType(int options)
	{
		this.options = options;
	}
	public int getOptions()
	{
		return options;
	}
}
class PizzaShop
{
	void getMenu()
	{
		System.out.println("WE HAVE THE FOLLOWING SIZES: ");
		for(PizzaSize size : PizzaSize.values())
		{
			System.out.println(size + "---  serves  " + size.getServing() + " people");
		}

		/*PizzaSize size = new PizzaSize.SMALL;
		System.out.println(size);

		size = new PizzaSize.MEDIUM;
		System.out.println(size);

		size = new PizzaSize.LARGE;
		System.out.println(size);*/
	}

	void getType()
	{
		System.out.println("WE HAVE THE FOLLOWING OPTION");
		for(PizzaType type : PizzaType.values())
		{
			System.out.println(type + " haves " + type.getOptions() + " options");
		}
	}
}

class EnumDemo
{
	public static void main(String[] args) 
	{
		PizzaShop customer =  new PizzaShop();
		customer.getMenu();	
		customer.getType();
	}
}