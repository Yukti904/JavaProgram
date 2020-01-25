class BinaryEquivalent
{
	public static void main(String[] args) {
		int Number = Integer.parseInt(args[0]);
		int Answer;

		System.out.println("The binary equivalent is : ");

		for(int i = Number ; i > 0 ; )
		{
			Answer = i % 2;
			i = i / 2;
			System.out.println(Answer + " ");
		}
	}
}