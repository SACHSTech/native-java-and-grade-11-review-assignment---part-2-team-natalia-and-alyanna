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

         boolean testing = Utility.linearIn(new int[]{1, 2, 4, 6, 3}, new int[]{2, 4});
         System.out.println(testing);

         //Testing Array 5
         Utility.pascalTri(4,5);


    }
}