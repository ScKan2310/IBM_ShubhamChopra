import java.util.Scanner;
enum PizzaSize 
{
   SMALL(2),MEDIUM(3),LARGE(4),XLARGE(6);

   private int serving;

   private PizzaSize(int var3) 
   {
      this.serving = var3;
   }

   public int getServing() 
   {
      return this.serving;
   }
}

enum PizzaType
 {
   VEG(5), NONVEG(6);

   private int options;

   private PizzaType(int var3) 
   {
      this.options = var3;
   }
   

   public int getOptions() 
   {
      return this.options;
   }
}

enum PizzaVeg
{
   PANEER_ONION, PANER_CACPCICUM, PANEER_ALL_VEGIES, PANEER_CORN, ONION_CAPCICUM
}

enum PizzaNonVeg
{
  BBQ, TANDURI_CHICKEN, OVERLOADED, PORK_CORN, SMOKED, INDIAN_MASALA
}
class PizzaShop 
{ 
   
      void getMenu() 
      {
         System.out.println("WE HAVE THE FOLLOWING SIZES: ");
         PizzaSize[] var1 = PizzaSize.values();
         int var2 = var1.length;

         for(int var3 = 0; var3 < var2; ++var3) 
         {
            PizzaSize var4 = var1[var3];
            System.out.println(var4 + "---  serves  " + var4.getServing() + " people");
         }

      }

      void getType() 
      {
         System.out.println("WE HAVE THE FOLLOWING OPTION");
         PizzaType[] var1 = PizzaType.values();
         int var2 = var1.length;

         for(int var3 = 0; var3 < var2; ++var3) 
         {
            PizzaType var4 = var1[var3];
            System.out.println(var4 + " haves " + var4.getOptions() + " options");
         }
      }

      void getVeg()
      {
         System.out.println("WE HAVE THE FOLLOWING OPTIONs FOR VEG");
         PizzaVeg[] var1 = PizzaVeg.values();
         int var2 = var1.length;
         for(int var3 = 0; var3 < var2; ++var3) 
         {
            PizzaVeg var4 = var1[var3];
            System.out.println("---" + var4 );
         }
      }

      void getNonVeg()
      {
         System.out.println("WE HAVE THE FOLLOWING OPTIONs FOR NONVEG");
         PizzaNonVeg[] var1 = PizzaNonVeg.values();
         int var2 = var1.length;
         for(int var3 = 0; var3 < var2; ++var3) 
         {
            PizzaNonVeg var4 = var1[var3];
            System.out.println("---" + var4);
         }
      }
} 

class Pizza
{
   public static void main(String[] args)
   {
      PizzaShop p = new PizzaShop();
      p.getMenu();
      p.getType();

      int value=0;
      Scanner scan = new Scanner(System.in);
      System.out.println("ENTER 1 FOR VEG AND 2 FOR NON VEG AND PRESS ENTER");
      value = scan.nextInt();
      switch(value)
      {
         case 1: 
         {
            p.getVeg();
            break;
         }

         case 2:
         {
            p.getNonVeg();
            break;
         }
      }
   }
}