import java.util.*;
class Reverse{
	public static void main(String[] args) {
		System.out.println("Enter a string : ");
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		int length = s.length();
		String reverse = "";
		for(int i = length - 1; i >= 0; i--){
			reverse = reverse + s.charAt(i);

	}
	System.out.println("Reverse of the string is : " + reverse);
}
}