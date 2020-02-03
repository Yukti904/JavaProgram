import java.util.Scanner;
class MyException extends Exception{
	MyException(String s){
		super(s);
			}
}
class PrintPrimeNumbers{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the limit (n)");
		int n = scan.nextInt();
		try{ 
			if(n < 0){
				throw new MyException("Invalid input");
			}
			else {
		for(int i = 2; i <= n; i++){
			int count = 0;
			for(int j = 2; j < i; j++){
				if(i % j == 0)
				{
					count++;
					break;
				}
			}
			if(count == 0){
				System.out.println(i);		
					}
		        
		    }
		    } catch(Exception e){
		    	System.out.println("Excecption caught : invalid input");
		    }

			}
}