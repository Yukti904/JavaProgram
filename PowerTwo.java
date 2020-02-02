import java.util.*;
class PowerTwo{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number to be checked");
		int n=sc.nextInt();
		if(TwoPowerNumber(n))
		{
			System.out.println("the number is the power of two");
		}
		else
		{
			System.out.println("the number is not the power of two");
		}

	}

	static boolean TwoPowerNumber(int num)
	{
		if(num==0)
		return false;
	  while(num!=1)
	  {
	  	if(num%2!=0)
	  	{
	  		return false;
	  	}
	  	num=num/2;
	  }
	  return true;
	}
}