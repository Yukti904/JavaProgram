import java.util.*;

class ValidUserName{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the username : ");
		String str = new String(scan.next());
		if(ValidateUserName(str))
		System.out.println("Valid user name");
		else
		System.out.println("Not a valid user name");
			}
			static boolean ValidateUserName(String str){
				int len = str.length();
				int before = len - 4;
				String job = new String("_job");
				String sub1 = str.substring(0, before);
				String sub2 = str.substring(before, len);
				if(sub2.matches(job) && (sub1.length() > 7))
					return true;
				return false;
			}
}