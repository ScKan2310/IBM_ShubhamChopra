import java.util.Scanner;
class TrafficLight
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		while(true)
		{
			int choice = scan.nextInt();	
			switch(choice)
			{
				case 1 : 
					System.out.println("Stop");
					break;
				case 2 :
					System.out.println("Ready");
					break;
				case 3 :
					System.out.println("Go");
					break;
				default :
					try{
						throw new IllegalStateException();
					}catch(IllegalStateException e){
						e.printStackTrace();
					}
			}
		}
	}	
}