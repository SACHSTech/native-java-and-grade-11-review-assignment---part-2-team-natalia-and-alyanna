package gr11review.part2;
import java.io.*;
import java.util.Scanner;
public class Utility {

    //Methods 1
    public static String zipZap(String str){

        String strNew;

        //Removes all letters between the pattern "z_p"
        strNew = str.replaceAll("z[a-zA-Z]p", "zp");
        
        return strNew;
    } 

    //File IO - Read 1
    public static String longestWord(String filenametxt){
        
        String longestWord = "";
        String currentWord;
        
        try (Scanner fileScan = new Scanner (new File(filenametxt))){

            while (fileScan.hasNext()){
                currentWord = fileScan.next();

                if(currentWord.length() > longestWord.length()){
                    longestWord = currentWord;
                }
            }

        }catch (Exception a){
            System.out.println("Error");
        }

    
        return longestWord;
    }
}
