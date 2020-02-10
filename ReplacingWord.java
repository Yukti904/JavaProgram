import java.io.*;

public class ReplacingWord {

     

    public static void main(String[] args) throws java.lang.Exception {
          /* Scanner scan = new Scanner(System.in);
           System.out.println("Enter the word you want to replace");
           String new = scan.nextLine();*/
              String new = "and";
             String old = "is";
        
        String originalFilePath = "C://sample.txt";
        String originalFileContent = "";

        
        BufferedReader reader = null;
        BufferedWriter writer = null;

        
        try {

            
            reader = new BufferedReader(new FileReader(originalFilePath));

            
            String currentReadingLine = reader.readLine();

            
            while (currentReadingLine != null) {
                originalFileContent += currentReadingLine + System.lineSeparator();
                currentReadingLine = reader.readLine();
            }

            
            String modifiedFileContent = originalFileContent.replaceAll(new, old);

    
            writer = new BufferedWriter(new FileWriter(originalFilePath));

            
            writer.write(modifiedFileContent);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            
            try {
                if (reader != null) {
                    reader.close();
                }

                if (writer != null) {
                    writer.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}