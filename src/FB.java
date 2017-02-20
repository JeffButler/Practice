import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
   
 public class FB {
  
  //final static String FILE_NAME = "C:\\Users/\\Jeffery\\Documents\\BackUpData\\Documents\\Documents\\codeval\\multiples.txt";
  final static String FILE_NAME = "fb_test.txt";
  final static String OUTPUT_FILE_NAME = "multiples2.txt";
  final Charset ENCODING = StandardCharsets.UTF_8;
  public static void main (String[] args) throws IOException {
    File file = new File(args[0]);
    BufferedReader in = new BufferedReader(new FileReader(file));
    String line;
    while ((line = in.readLine()) != null) {
        String[] lineArray = line.split(" ");
        if (lineArray.length > 0) {
            //Process line of input Here
        }
    }

    //lines.add("This is a line added in code.");
    //text.writeSmallTextFile(lines, FILE_NAME);
    
  }
  List<String> readSmallTextFile(String aFileName) throws IOException {
      Path path = Paths.get(aFileName);
      return Files.readAllLines(path, ENCODING);
    }

    void fizzBizz(int A, int B, int N){
    	String main = "";
    	int num = 1;
    	while (num <= N){
    		String returnString = "";
    		if (num % A == 0){
    			returnString += "F";
    		}
    		if (num % B == 0){
    			returnString += "B"; 
    		}
    		if (returnString.equals("")){
    			main += num + " ";
    		}
    		else 
    			main += returnString + " ";
    		num++;
    	}
        main = main.trim();
        System.out.println(main);
    }
}