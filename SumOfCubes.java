import java.util.*;

class SumOfCubes{
	public static void main(String[] args) {

        System.out.println("Enter a number");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
	    Cubes(num);



}
        public static void Cubes(int temp){
		int sum = 0, rem;
		
		while(temp > 0){
			rem = temp % 10;
			sum += rem * rem * rem;
			temp = temp / 10;
	}
	   System.out.println("The sum of the cubes of individual digits is : " + sum);
	    
		
	}
}
