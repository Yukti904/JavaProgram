import java.io.*;
import java.util.*;
 
class FileOperations{
 
public static void main(String[] args){
Scanner input = new Scanner(System.in);
System.out.println("Enter the name of the file:");
String fileName = input.nextLine();
File file = new File(fileName);
 
if(file.exists())
System.out.println("The file " +fileName+ " exists");
else
System.out.println("The file " +fileName+ " does not exist");
 
if(file.exists()){
if(file.canRead())
System.out.println("The file " +fileName+ " is readable");
else
System.out.println("The file " +fileName+ " is not readable");
 
if(file.canWrite())
System.out.println("The file " +fileName+ " is writeable");
else
System.out.println("The file " +fileName+ " is not writeable");
 
System.out.println("The file type is: " +fileName.substring(fileName.indexOf('.')+1));
 
System.out.println("The Length of the file:" +files.length());
}
 
}
}