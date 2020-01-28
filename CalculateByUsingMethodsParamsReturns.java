import java.util.Scanner;
class CalculateByUsingMethodsParamsReturns
{
	int firstNum; 
	int secondNum;
	int addNum()
	{
		return (this.firstNum + this.secondNum);
	}
	void displayNum()
	{
		System.out.println("the addition is: " + this.addNum() );
	}
	void insertNum()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the two nos: ");
		this.firstNum = scan.nextInt();
		this.secondNum = scan.nextInt();
		this.displayNum();
	}
	public static void main(String[] args) 
	{
		new CalculateByUsingMethodsParamsReturns().insertNum();
	}
}