
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
   VEG(9), NONVEG(16);

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
} 

class Pizza
{
   public static void main(String[] args)
   {
      PizzaShop p = new PizzaShop()
      p.getMenu();
      p.getType();
   }
}