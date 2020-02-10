import java.io.*;
import java.util.*;

class FileReadAndDisplay{
    public static void main(String[] args) throws IOException{
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the path where the directory is stored : ");
        String path = scan.next();
        System.out.println("Enter the desired name of the directory : ");
        path = path + scan.next();
        File dir = new File(path);
        dir.mkdir();

        
      
        char [] arr = new char[100];
        int size = 0;
        File file = new File(dir, "MyFile.txt");
        FileWriter fw = new FileWriter(file);
        fw.write("Hi\neveryone\nWe\nare\ninside\nMyFile");
        fw.flush();
        fw.close();

    

   
        String fname;
        System.out.println("Enter the file name to be read(with the extension) : ");
        fname = scan.nextLine();
        LineNumberReader num1 = null;
        num1 = new LineNumberReader(new FileReader(fname));
        System.out.print("Line : " + num1.getLineNumber());
        num1.setLineNumber(1);
        String line = null;
        try{
        while((line = num1.readLine()) != null)
        {
            System.out.println("Line" + num1.getLineNumber() + ":" +line);
        }
    } catch(IOException e){
            e.printStackTrace();
    }
        finally
        {
            if(num1 != null)
        {
            num1.close();
        }

        }
        



    }
}      









