import java.util.*;

class SortStringArray{
	public static void main(String[] args){
		int count;
        String temp;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number of strings : ");
        count = scan.nextInt();
        String str[] = new String[count];
        Scanner scan2 = new Scanner(System.in);      
        System.out.println("Enter the Strings one by one:");
        for(int i = 0; i < count; i++)
        {
            str[i] = scan2.nextLine();
        }
        for (int i = 0; i < count; i++) 
        {
            for (int j = i + 1; j < count; j++) 
            { 
                if (str[i].compareTo(str[j]) > 0) 
                {
                    temp = str[i];
                    str[i] = str[j];
                    str[j] = temp;
                }
            }
        }

        }
       
       System.out.println(Arrays.toString(str));
      if(count % 2 == 0 ){
      
        for(int i = 0; i <= count/2; i++){
        	System.out.println(str[i].toUpperCase());
        }
    }
        else
        {
        	for(int i = 0; i <= count/2 + 1; i++){
        		System.out.println(str[i].toLowerCase());
        	}
        }
    }
}
	