package gr11review.part2;
import java.io.*;
import gr11review.part2.*;

public class Main{
    public static void main(String[] args) throws IOException{

        //Testing Methods 1
        String test = "zipaaaaaaaaaXzapzapzap";
        String result;

        result = Utility.zipZap(test);

        System.out.println(result);

        //Testing FileIO Read 1
        String word;

        word = Utility.longestWord("testfile.txt");

        System.out.println(word);

    }
}