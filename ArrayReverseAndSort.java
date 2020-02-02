import java.util.*;
class ArrayReverseAndSort{
	public static void main(String[] args) {
		int i;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the no.of input");
		int n=sc.nextInt();
		System.out.println("enter the numbers");
		String[] input=new String[n];
		for(i=0;i<n;i++)
		{
			input[i]=sc.nextLine();
		}
		
		System.out.println("the sorted array is");
		SortedArray(input,n);

	}
	static void SortedArray(String [] in,int num)
	{
		int i=0,j,k,l,temp,y,h,c;
		 String[] revv=new String[num];
		 for(h=0;h<num;h++)
		 {
		    revv[h]=StringReverse(in[h]);
		 }
		 for(c=0;c<num;c++)
		 {
		 	System.out.println("the reversed number array is : "+revv[c]);
		}
		String re=SingleString(revv,num);

        int [] arr=new int[num];
        StringTokenizer st=new StringTokenizer(re," ");
        while(st.hasMoreTokens())
        {
        	String out=st.nextToken();
        	int no=Integer.parseInt(out);
        	System.out.println(no);
            arr[i++]=no;
        }
        for(y=0;y<num;y++)
        {
             System.out.println("the array is : "+ arr[y]);
        }
        for(j=0;j<num;j++)
        {
        	for(k=j+1;k<num;k++)
        	{
                if(arr[k]<arr[j])
                {
                	temp=arr[j];
                	arr[j]=arr[k];
                	arr[k]=temp;
                }
        	}
        }
        
       for(l=0;l<num;l++)
       {
       	 System.out.println(arr[l]);
       }

	} 

	static String StringReverse(String inp)
	{
		StringBuilder input=new StringBuilder();
 		input.append(inp);
 		StringBuilder input1=input.reverse();
 		String rev=input1.toString();
 		return rev;
	}

	static String SingleString(String[] arr,int n)
	{
		StringBuffer sb=new StringBuffer();
		int g;
		for(g=0;g<n;g++)
		{
			sb.append(arr[g]);
		}
		String ans=sb.toString();
		return ans;
	}

 }