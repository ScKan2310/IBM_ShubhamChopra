interface Human
{
 
     int VAR = 98;
 
     void breathe();
     void eat();
     void run();
 
     static void talk()
     {
        System.out.println("Generic talk, added later on...");
     }
}
 
//new Human();//Banned
interface Employee extends Human
{
    void work();
}
 
interface Warrior
{
    void fight();
    void run();
}
 
class Sameer implements Human
{
 
    @Override
    public void fight()
    {
        System.out.println("Sameer fights well...");
    }
     
    @Override
    public void eat()
    {
        System.out.println("Sameer can eat in his own way..." + Human.VAR);
    }
 
    @Override
    public void run()
    {
        System.out.println("Sameer can run in his own way...");
    }
 
    @Override
    public void breathe()
    {
        System.out.println("Sameer can breathe in his own way...");
    }

    void noWork()
    {
        System.out.prinln("Sameer wont work now");
    }
 
 
}
class Rashmi implements Human
{
 
    @Override
    public void work()
    {
        System.out.println("Rashmi's work...");
    }
 
    @Override
    public void eat()
    {
        System.out.println("Rashmi can eat in her own way..." + Human.VAR);
    }
 
    @Override
    public void run()
    {
        System.out.println("Rashmi can run in her own way...");
    }
 
    @Override
    public void breathe()
    {
        System.out.println("Rashmi can breathe in her own way...");
    }
 
    void swim()
    {
        System.out.println("Rashmi's own swim...");
    }
}
 
 
class InterfaceDemo
{
    public static void main(String[] args) 
    {
         Sameer ref = new Sameer();
         ref.breathe();
         ref.eat();
        // ref.talk();
         Human.talk();
 
         Rashmi ot = new Rashmi();
         ot.breathe();
         ot.eat();
         ot.work();
        // ot.talk();
         
    }
}