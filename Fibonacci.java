 class Fibonacci {

    public static void main(String[] args) {

        int  a = 1, b = 1;
        System.out.println(a);
        System.out.println(b);s
        for (int i =1; i <18 ; i++)
        {
          int sum = a + b;
          System.out.println(sum);
          a = b;
          b = sum;
        
        if(sum >= 89){
            break;
        }
        }
    }
}