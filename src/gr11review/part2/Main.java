package gr11review.part2;
import java.io.*;
import java.util.Arrays;
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

        //Testing Array 1
         int[] nums = Utility.tenRun(new int[] {10, 1, 20, 2});
         System.out.println(Arrays.toString(nums));

         //Testing Array 3

         boolean testing = Utility.linearIn(new int[]{1, 3, 5, 7, 9}, new int[]{5, 7});
         System.out.println(testing);


    }
}