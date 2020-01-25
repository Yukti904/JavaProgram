class SumOfThreeNumbers
{
	public static void main(String[] args) {
		int FirstNum = Integer.parseInt(args[0]);
		int SecondNum = Integer.parseInt(args[1]);
		int ThirdNum = Integer.parseInt(args[2]);

		int sum = FirstNum + SecondNum + ThirdNum;

		if(FirstNum  >= 40){
		 
		 if(SecondNum >= 40){

		 	if(ThirdNum >= 40){

		 		if(sum >= 125){
		 			System.out.println("PASSING");
		 		}
		 	}
		 }

		}
		else{
			System.out.println("FAILING");
		}
	}
}