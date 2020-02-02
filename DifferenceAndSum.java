import java.util.*;
class DifferenceAndSum{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the limit for the natural numbers :");
		int limit = scan.nextInt();
		CalculateDifference(limit);
	}
	public static int CalculateDifference(int n){
		int sum1 = 0;
		for(int i = 1; i <= n; i++){
			sum1 += (i * i);

		}
		System.out.println("The sum of the square of n natural numbers is: " + sum1);
		int sum2 = 0;
		for(int j = 1; j <= n; j++){
			sum2 += j;
		}
		sum2 *= sum2;
		System.out.println("The square of the sum of first n natural numbers is : " + sum2);

		int sum3 = sum1 - sum2;
		System.out.println(sum3);
		return sum3;


	}
}