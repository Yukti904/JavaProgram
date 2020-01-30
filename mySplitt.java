import java.util.*;

class mySplitt{
	public static void main(String[] args) {
		System.out.println("Enter a string");
		Scanner scan = new Scanner(System.in);
		String a = scan.nextLine();
		System.out.println("Enter the other string");
		String b = scan.nextLine();
		String []storeSplit = new String[a.length()];
		storeSplit = tokenizer(a,b);
		for (String str : storeSplit){
			if(str.equals(null)){
				continue;
			}
			else{
				System.out.println(str);
			}
		}
	}

	public static String[] tokenizer(String input, String dilimiter){
		String tempStr = new String();
		String []storeSplit =  new String[input.length()];
		int index = 0;
		for(int i = 0; i < input.length() - dilimiter.length() + 1; i++){
		if(input.substring(i, i + dilimiter.length()).equals(dilimiter)){
			storeSplit[index] = tempStr;
			tempStr = "";
			index++;
			i += dilimiter.length() - 1;
		}
		else{
			tempStr += input.substring(i, i + 1);
		}
		}
		tempStr = input.substring(input.length() - dilimiter.length() + 1, input.length());
		storeSplit[index] = tempStr;
		return storeSplit;
	}
}
