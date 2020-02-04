import java.util.*;

class TrafficLights{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Choose from the following options : ");
		System.out.println("Red");
		System.out.println("Green");
		System.out.println("Yellow");
        String choice = scan.nextLine();
        switch(choice){
        	case "Red":
        	System.out.println("You need to stop!");
        	break;
        	case "Green":
        	System.out.println("You can go...");
        	break;
        	case "Yellow":
        	System.out.println("Start your vehicles");
        	break;
        	default:
        	System.out.println("--Not a valid option--");
        	break;
        }

	}
}