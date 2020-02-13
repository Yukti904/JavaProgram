import java.io.*;


class CopyDataThread implements Runnable{
 public void run(){
		boolean b = true;
		try{
			File srcfile = new File("source.txt");
			File trgtfile = new File("target.txt");
			char[] input = new char[200];
			int i = 0;
			FileReader fr = new FileReader(srcfile);
			FileWriter fw = new FileWriter(trgtfile);
			fr.read(input);
			//System.out.print(in);

			do{
			for (int j = i; j < i+10 ; j++ ) {
				fw.write(input[j]);
				fw.flush();
				if(input[j]=='\0'){
					b = false;
					break;
				}
			}
				System.out.println("10 characters copied! "); 
				i += 10;
			}
			while(b);
		
		
		fr.close();
		fw.close();
		} catch(IOException e) {System.out.println("Exception while file handling"); }
		try{
			Thread.sleep(5000);
		}catch(InterruptedException e){
			System.out.println("Sleep error");
		}
	}
}



class MyFileProgram{
	public static void main(String[] args) {
		CopyDataThread obj = new CopyDataThread();
		Thread thread = new Thread(obj);
		thread.run();

	}
	
}