import java.util.*;
class PositiveString{
	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the input string");
	String str= sc.nextLine();
	Positive(str);
}







    static void Positive(String input)
    {

    
	char []ch=new char[input.length()];
	int [] arr=new int[input.length()];
	int j,i;
	for(i=0;i<input.length();i++)
	{
		ch[i]=input.charAt(i);
		arr[i]=(int)ch[i];
	}

	for(j=0;j<input.length()-1;j++)
	{
		if(arr[j]>arr[j+1])
		{
			System.out.println("the string is not positive");
			return;
		}
		 
	}
	 System.out.println("the string is positive");

	}

}