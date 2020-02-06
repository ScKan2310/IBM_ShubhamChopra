import java.util.*;
class CustomClassollectionAPI
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		List l = new ArrayList();
		int flag =1;
		while(flag == 1)
		{	
			System.out.println("Press 1 from adding a computer");
			System.out.println("Press 2 for displaying");
			System.out.println("Press 3 for searching");
			System.out.println("Press 4 for deleting with id");
			System.out.println("Press 5 for Updating");
			System.out.println("Press any other Integer for stopping");
			int choice = scan.nextInt();
			switch(choice)
			{
				case 1 :
				{
					System.out.println("enter the number of computers");
					int n= scan.nextInt();
					for(int i=1;i<=n;i++)
					{
						System.out.println("Enter the following for computer " + i);
						Computer c = input();
						l.add(c);
					}
				}
				case 2 :
					display(l);
					break;
				case 3 :
					searchList(l);
					break;
				case 4 :
					deleteId(l);
					break;
				case 5 :
					update(l);
					break;
				default :
					flag =0;
					break;
			}

		}

	}

	public static void display(List l)
	{
		System.out.println("THE COMPUTERS YOU ENTERED HAVE THE FOLOWING PROPERTIES");
		for(Object ref :l)
		{	
			System.out.println(ref);
		}
	}

	public static void searchList(List l)
	{	
		Scanner scan = new Scanner(System.in);
		System.out.println("enter 1 for By BRAND");
		System.out.println("enter 2 for By COLOR");
		System.out.println("enter 3 for By HDDSIZE");
		System.out.println("enter 4 for By RAMSIZE");
		System.out.println("enter 5 for By ID");	
		int a =scan.nextInt();

		switch(a)
		{
			case 1:
			{
				System.out.println("Enter the brand");
				scan.nextLine();
				String brand_check = scan.nextLine();
				for(Object ref : l)
				{
					if(ref instanceof Computer)
					{
						if(brand_check.equals(((Computer)ref).getBrand()))
						{
							System.out.println(ref);
						}
						else
							System.out.println("not found");
					}
				}
				break;
			}

			case 2:
			{
				System.out.println("Enter the color");
				scan.nextLine();
				String color_check = scan.nextLine();
				for(Object ref : l)
				{
					if(ref instanceof Computer)
					{
						if(color_check.equals(((Computer)ref).getColor()))
						{
							System.out.println(ref);
						}
						else
							System.out.println("not found");
					}
				}
				break;
			}

			case 3 :
			{
				System.out.println("Enter the HDDSIZE");
				
				int hdd_check = scan.nextInt();
				scan.nextLine();
				for(Object ref : l)
				{
					if(ref instanceof Computer)
					{
						if(hdd_check == (((Computer)ref).getHddSize()))
						{
							System.out.println(ref);
						}
						else
							System.out.println("not found");
					}
				}
				break;
			}

			case 4:
			{
				System.out.println("Enter the RAMSIZE");
				
				int ram_check = scan.nextInt();
				scan.nextLine();
				for(Object ref : l)
				{
					if(ref instanceof Computer)
					{
						if(ram_check == (((Computer)ref).getRamSize()))
						{
							System.out.println(ref);
						}
						else
							System.out.println("not found");
					}
				}
				break;
			}

			case 5:
			{
				System.out.println("Enter the id");
				scan.nextLine();
				String id_check = scan.nextLine();
				for(Object ref : l)
				{
					if(ref instanceof Computer)
					{
						if(id_check.equals(((Computer)ref).getId()))
						{
							System.out.println(ref);
						}
						else
							System.out.println("not found");
					}
				}
				break;
			}
		}
	}

	public static void deleteId(List l)
	{	
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the ID to be Deleted");
		String id_delete = scan.nextLine();
		for(Object ref : l)
		{	
			if(id_delete.equals(((Computer)ref).getId()))
			{
				l.remove(ref);
				break;
			}
		}
		System.out.println("after deletion");
		display(l);
				
	}

	public static void update(List l)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the id to be updated");
		String id_check = scan.nextLine();
		for(Object ref : l)
		{
			if(ref instanceof Computer)
			{
				if(id_check.equals(((Computer)ref).getId()))
				{
					System.out.println("Press 1 to update brand");
					System.out.println("Press 2 to update color");
					System.out.println("Press 3 to update hddSIze");
					System.out.println("Press 4 to update ram size");
					System.out.println("Press 5 to update id");
					int a = scan.nextInt();
					scan.nextLine();

					switch(a)
					{
						case 1 :
						{
							System.out.println("Enter the new brand name");
							String brand_new = scan.nextLine();
							((Computer)ref).setBrand(brand_new);
							break;
						}

						case 2 :
						{
							System.out.println("Enter the new color name");
							String color_new = scan.nextLine();
							((Computer)ref).setColor(color_new);
							break;
						}

						case 3 :
						{
							System.out.println("Enter the new hddSize");
							int hdd_new = scan.nextInt();
							((Computer)ref).setHddSize(hdd_new);
							break;
							
						}

						case 4 : 
						{
							System.out.println("Enter the new ramSize");
							int ram_new = scan.nextInt();
							((Computer)ref).setRamSize(ram_new);
							break;
						}

						case 5 :
						{
							System.out.println("Enter the new id");
							String id_new = scan.nextLine();
							((Computer)ref).setId(id_new);
							break;
						}

					}
				}
				else
					System.out.println("not found");
			}
		}
		display(l);
	}
			

	
	public static Computer input()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter BRAND of computer");
		String brand = scan.nextLine();
		System.out.println("Enter COLOR of computer");
		String color = scan.nextLine();
		System.out.println("Enter ID of computer");
		String id = scan.nextLine();
		System.out.println("Enter HDDSIZE of computer");
		int hddSize = scan.nextInt();
		System.out.println("Enter RAMSIZE of computer");
		int ramSize = scan.nextInt();

		return (new Computer(brand,color,id,hddSize,ramSize));


	}
}

class Computer
{
	String brand, color ,id;
	int hddSize, ramSize;

	Computer(String brand, String color, String id , int hddSize, int ramSize)
	{
		this.brand=brand;
		this.color=color;
		this.hddSize=hddSize;
		this.ramSize=ramSize;
		this.id=id;
	}

	public String getColor()
	{
		return this.color;
	}

	public String getBrand()
	{
		return this.brand;
	}

	public String getId()
	{
		return this.id;
	}	

	public int getHddSize()
	{
		return this.hddSize;
	}

	public int getRamSize()
	{
		return this.ramSize;
	}

	public void setBrand(String brand_new)
	{
		this.brand = brand_new;
	}

	public void setColor(String color_new)
	{
		this.color = color_new;
	}

	public void setHddSize(int hdd_new)
	{
		this.hddSize = hdd_new;
	}

	public void setRamSize(int ram_new)
	{
		this.ramSize= ram_new;
	}

	public void setId(String id_new)
	{
		this.id = id_new;
	}


	@Override
	public String toString()
	{
		return " Brand is : " + this.getBrand() +
				" ;    Color is : " + this.getColor() +
				" ;    ID is : " + this.getId() +
				" ;    hddSize is : " + this.getHddSize() +
				" ;    ramSize is : " + this.getRamSize();
	}



	// @Ovveride
	// public boolean equals(String ref)
	// {
	// 	return this.
	// }
}