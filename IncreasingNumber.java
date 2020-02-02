import java.util.*;
class IncreasingNumber{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the no.of digits");
		int n=sc.nextInt();
		int [] arr=new int[n];
		int i;
		for(i=0;i<n;i++)
		{
			arr[i]=sc.nextInt();
		}
		if(Increase(arr,n))
		{
			System.out.println("the number is an increasing number");
		}
		else
		{
			System.out.println("the number is not an increasing number");
		}

    }

    static boolean Increase(int[] in,int n)
    {
        int i,j;
        for(i=0;i<n;i++)
        {
        	for(j=i+1;j<n;j++)
        	{
        		if(in[i]>in[j])
        		{
        			return false;
        		}
        	}
        }

        return true;
    }
}