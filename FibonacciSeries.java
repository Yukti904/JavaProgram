import java.util.Scanner;
class MyException extends Exception{
	MyException(String s){
		super(s);
			}
}
class FibonacciSeries{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the limit");
		int limit = scan.nextInt();
		try{ 
			if(limit < 0){
				throw new MyException("Invalid input");
			}
			else{
	System.out.print("Fibonacci Series of "+ limit +" numbers: ");
	for(int i = 0; i < limit; i++){
			System.out.print(fibonacciRecursion(i) +" ");
		
	}
}
} catch(Exception e){
	System.out.println("Exception : negative input not allowed");
}
}

	 static int fibonacciRecursion(int n){
	if(n == 0){
		return 0;
	}
	if(n == 1 || n == 2){
			return 1;
		}
	return fibonacciRecursion(n-2) + fibonacciRecursion(n-1);
	}
}