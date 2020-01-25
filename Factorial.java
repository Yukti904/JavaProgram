class Factorial
{
   public static void main(String[] args) {
       
        int n=Integer.parseInt(args[0]);
        int fact = 1, i;


        if(n < 0){
        	System.out.println("Invalid number");
        }
        else{
        	for(i = 1 ; i <= n ; i++){
              fact *= i;
        	}
        	System.out.println("Factorial of the number is : " + fact);
        }

   }


}
