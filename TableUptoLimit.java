class TableUptoLimit
{
	public static void main(String[] args) {
		
		int n = Integer.parseInt(args[0]);
		int Limit = Integer.parseInt(args[1]);

		for(int i = 1 ; i <= Limit ; i++){
			int Product = n * i;
			System.out.println(n + " * " + i + " = " + Product);

			}
		}
}