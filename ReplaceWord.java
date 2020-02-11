import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.util.Scanner;
import java.io.BufferedReader;

class ReplaceWord{	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the string to be modified : ");
		String old = scan.nextLine();
		System.out.println("Enter the string to be replaced :");
		String newS = scan.nextLine();
		modifyFile("C:/javaprograms/MyFile.txt", old, newS);
		
		
	}
	static void modifyFile(String file, String old, String newS){
		File fileModified = new File(file);	
		String oc = "";
		BufferedReader reader = null;
		FileWriter writer = null;
		try{
			reader = new BufferedReader(new FileReader(fileModified));		
			String line = reader.readLine();	
			while (line != null){
				oc = oc + line + System.lineSeparator();		
				line = reader.readLine();
			}		
			String nc = oc.replaceAll(old, newS);						
			writer = new FileWriter(fileModified);			
			writer.write(nc);
		}
		catch (IOException e){
			e.printStackTrace();
		}
		finally{
			try{
				reader.close();	
				writer.close();
			} 
			catch (IOException e){
				e.printStackTrace();
			}
		}
	}
	
	
}
