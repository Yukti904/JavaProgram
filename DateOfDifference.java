import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

class DateOfDifference{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the date in (yyyy:mm:dd) : ");
		String inp=sc.nextLine();
        DateDiff(inp);

	}
	static void DateDiff(String date)
	{
         String [] token=new String[3];
         token=date.split(":");
         int years=Integer.parseInt(token[0]);
         int months=Integer.parseInt(token[1]);
         int days=Integer.parseInt(token[2]);
         LocalDate givendate=LocalDate.of(years,months,days);
         LocalDate currentdate=LocalDate.now();
         Period diff=Period.between(givendate,currentdate);
         System.out.println("Difference is %d years,%d months and %d days old"+diff.getYears() +diff.getMonths() +diff.getDays());
	}
}