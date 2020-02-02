import java.util.Scanner;

class SecondSmallest
{
    public static void main(String[] args) 
    {
    	
        int n;
        Scanner scan = new Scanner(System.in);
        
        
        System.out.print("Enter number of elements : ");
        n = scan.nextInt();
        
        
        int a[] = new int[n];
        
      
        System.out.println("Enter the elements in array : ");
        for (int i = 0; i < n; i++) 
        {
            a[i] = scan.nextInt();
        }
         GetSecondSmallest(a,n);

       }

        static int GetSecondSmallest(int[] arr, int size){
        	int min;
        for (int i = 0; i < size; i++) 
        {
            for (int j = i + 1; j < size; j++) 
            {
                if (arr[i] > arr[j]) 
                {
                    min = arr[i];
                    arr[i] = arr[j];
                    arr[j] = min;
                }
            }
        }
        System.out.println("The Second smallest element in the array is :"+arr[1]);
        
        return arr[1];
    } 
    
}
