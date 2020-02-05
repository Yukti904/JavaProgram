import java.util.concurrent.ThreadLocalRandom;
class RandomNumber extends Thread{
	public static void main(String[] args) {
		System.out.println("Generating 100 random integers");
		for(int i = 0; i < 100; i++) {
			System.out.println(ThreadLocalRandom.current().nextInt());
		}
		
		System.out.println("Generating 3 random floats:");
		for(int i = 0; i < 3; i++){
			System.out.println(ThreadLocalRandom.current().nextDouble());
		}

	}
}