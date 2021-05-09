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

    //Array 1 - One Dimensional
    public static int[] tenRun(int[] nums){
        
        for (int i = 0; i < nums.length - 1; i++){

            //if the number is a multiple of 10
            if (nums[i] % 10 == 0){ 

                //if the next number is not a multiple of 10
                if (nums [i + 1] % 10 != 0){

                    //replace the next number with the previous multiple of 10
                    nums[i + 1] = nums[i];
                }
            }
        }
        return nums;
    }

    //Array 3 - One Dimensional
    public static boolean linearIn(int[] outer, int[] inner){

        //if all the numbers in the inner array appear in the outer array, return true
       int d = 0;
       
        for (int i = 0; i < outer.length; i++){
            if (outer[i] == inner[d]){


            }

        }
        return true;
    }




    //Array 5 - Two Dimensional
    public static void pascalTri(int i, int j){

    }
    
}
