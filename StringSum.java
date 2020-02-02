import java.util.*;
class StringSum{
	public static void main(String[] args) {
	  Scanner sc=new Scanner(System.in);
	  System.out.println("Enter the String");
	  String input= new String(sc.nextLine());
	  // int num=Integer.parseInt(input);

	  //String del=new 
	  StringTokenizer in=new StringTokenizer(input," ");
	  int sum=0;
	  while(in.hasMoreTokens())
	  {
	  	//System.out.println(in.nextToken());
        String out=in.nextToken();
        int num=Integer.parseInt(out);
        System.out.println(num);
        sum=sum+num;
	  }
      
	  System.out.println("the sum of the integers is : "+sum);
      
	}
}