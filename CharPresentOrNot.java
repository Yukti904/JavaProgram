import java.util.*;
class CharPresentOrNot{
	public static void main(String[] args) {
		System.out.println("Enter a string");
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		char []a = s.toCharArray();
		System.out.println("Enter a character");
	    char b = scan.next().charAt(0);
	    int d = 0;
	    int count = 0;
	    for(int i = 0; i < a.length; i++){
	    	if(a[i] == b)
	    	{
	    		d = i;
	    		System.out.println("Character is present at " + d);
	    		count = count + 1;
	    	}

	}
}
}
