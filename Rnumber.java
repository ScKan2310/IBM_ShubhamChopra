import java.util.concurrent.ThreadLocalRandom;
class Rnumber extends Thread
{
	public static void main(String[] args) 
	{
		Rnumber r = new Rnumber();
		r.setName("shubham");
		r.start();
	}

	public void run()
	{	while(true)
		{
			int n = ThreadLocalRandom.current().nextInt();
			System.out.println(n);
			try{
				Thread.sleep(2000);
			}catch(InterruptedException ie){
	   			System.out.println("Someone just interrupted me :(");
			}
		}
	}
}