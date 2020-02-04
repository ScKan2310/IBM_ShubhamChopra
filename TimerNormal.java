class TimerNormal extends Thread
{
	public static void main(String[] args) 
	{
		T t1 = new T();
		t1.setName("Shubham");
		t1.start();	
	}

	@Override
	public void run()
	{
		int i = 1;
		while(true)
		{
			System.out.print(i);
			System.out.print("\b\b\b\b\b\b\b\b\b\b\b\b");
			try{
				Thread.sleep(1000);
			}catch(InterruptedException ie){
       			 System.out.println("Someone just interrupted me :(");
			}
			i++;
		}
	}	
}