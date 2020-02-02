class RuntimePoly
{
	public static void main(String[] args) 
	{
		 Sameer r = new Sameer();
		 r.noWork();
		// Rashmi r = new Rashmi();
		// ref.eat();	
		// ref.breathe();

		// ref = new Rashmi();//IS-A MAKES IS WORKING

		// ref.eat();
		// ref.breathe();
		//r.swim();

		Human []arr = new Human[10];

		for(int i=0 ; i<5; i++)
		{
			arr[i] = new Sameer();
		}
		for(int i=5; i<10 ; i++)
		{
			arr[i] = new Rashmi();
		}

		for(Human ref : arr)
		{
			ref.eat();


			if(ref instanceof Rashmi)
			{
				((Rashmi)ref).swim();   //-------- reference variable casting
			}
			else if(ref instanceof Sameer)
			{
				((Sameer)ref).noWork();
			}
		}

	}
}