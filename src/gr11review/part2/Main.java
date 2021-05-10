package gr11review.part2;
import java.io.*;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException{

        //Testing Methods 1
        String test = "zipaaaaaaaaaXzapzapzap";
        String result;

        result = Utility.zipZap(test);

        System.out.println(result);
        
        
        // Methods 2
        System.out.println(Utility.sumNumbers("abc123xyz"));
        System.out.println(Utility.sumNumbers("aa11b33"));
        System.out.println(Utility.sumNumbers("7 11"));

        //Testing FileIO Read 1
        String word;

        word = Utility.longestWord("testfile.txt");
        System.out.println(word);
        
        // File IO - Read 2
        System.out.println(Utility.alphaWord("resource/filenametxt.txt"));

        //Testing Array 1
         int[] nums = Utility.tenRun(new int[] {10, 1, 20, 2});
         System.out.println(Arrays.toString(nums));
         
         // Array 2 - One Dimensional
        System.out.println(Arrays.toString(Utility.notAlone(new int[]{1,2,3}, 2)));
        System.out.println(Arrays.toString(Utility.notAlone(new int[]{1,2,3,2,5,2}, 2)));
        System.out.println(Arrays.toString(Utility.notAlone(new int[]{3,4}, 3)));


         //Testing Array 3

         boolean testing = Utility.linearIn(new int[]{1, 2, 4, 6, 3}, new int[]{2, 4});
         System.out.println(testing);
         
         // Array 4 - One Dimensional - Two Loops
        System.out.println(Utility.canBalance(new int[]{1,1,1,2,1}));
        System.out.println(Utility.canBalance(new int[]{2,1,1,2,1}));
        System.out.println(Utility.canBalance(new int[]{10,10}));

         //Testing Array 5
         Utility.pascalTri(4,5);
        // Array 6 - Two Dimensional
         Utility.diagonal(8);
         System.out.println("diagonal method finished");
      
  }
}