import java.util.*;

class Timer extends Thread
{
	public static void main(String[] args) 
	{
		Timer t = new Timer();
		
		t.setName("Timer");
		t.start();
		//long time = d.getTime();
		
	}

	@Override
	public void run()
	{	while(true)
		{
			Date d = new Date();
			Calendar c = Calendar.getInstance();
			c.setTime(d);
			c.add(Calendar.SECOND, 1);
			d = c.getTime();
			System.out.print("date and time is : " + d);
			System.out.print("\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b"); 
			try{
				Thread.sleep(1000);
			}catch(InterruptedException ie){
        		System.out.println("Someone just interrupted me :(");
			}
		}
	}
}