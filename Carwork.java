class Car
{
	private String chasisNo;
	private int regId;

	private String name, model, color, brand;

	public void setChasisNo(String chasisNo)
	{
		this.chasisNo = chasisNo;
	}

	public void setRegId(int regId)
	{
		this.regId = regId;
	}
	public String getChasisNo()
	{
		return this.chasisNo;
	}

	public int getRegId()
	{
		return this.regId;
	}

	Car(String chasisNo, int regId)
	{
		setChasisNo(chasisNo);
		setRegId(regId);
	}

	Car()
	{
		;
	}
}

class Carwork
{
	public static void main(String[] args) 
	{
		Car a = new Car();
		Car b = new Car("abcd4458", 988789);
		a.setChasisNo("ABSDOADOAJ");
		System.out.println("the chasis no is of a is: " + a.getChasisNo() + "\n" + b.getRegId() );
	}
}
















