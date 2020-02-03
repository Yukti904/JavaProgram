import java.util.Scanner;
class EmployeeException extends Exception{
	EmployeeException(String s){
		super(s);
			}
}
class EmployeeSalary{
	public static void main(String[] args) {
		System.out.println("Enter employee salary");
		Scanner scan = new Scanner(System.in);
		int sal = scan.nextInt();
		try{
			if(sal < 3000){
              throw new EmployeeException("Not valid salary");
			}
			else{
				System.out.println("Valid");
			}
		}catch(Exception e){
			System.out.println("Salary should not be less than 3000");
		}
	}
}