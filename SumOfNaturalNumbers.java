import java.util.*;

class SumOfNaturalNumbers{
	public static void main(String[] args) {
		 Scanner scan = new Scanner(System.in);
		 System.out.println("Enter the limit till which you want the sum");
		 int input = scan.nextInt();
		 System.out.println(calculateSum(input));
	}

	static int calculateSum(int n){
		int a, b, c;
		a = ((n / 3)) * (2 * 3 + (n / 3 - 1) * 3) / 2; 
        b = ((n / 5)) * (2 * 5 + (n / 5 - 1) * 5) / 2; 
        c = ((n / (3 * 5))) * (2 * (3 * 5) 
                          + (n / (3 * 5) - 1) * (3 * 5))/ 2; 
      
       int sum = a + b - c;
       return sum;

	}
}