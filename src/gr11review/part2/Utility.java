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
        int match = 0;
       
        if ( inner.length == 0){
            return true;
        }
        for (int i = 0; i < outer.length; i++){
           
            if (outer[i] == inner[d]){
                match++;
                d++;
            } else if (outer[i] > inner[d]){
                return false;
            }

            if (match == inner.length){
                return true;
            } 
        }

        return false;
    }

    public static void pascalTri(int i, int j) throws IOException{

        //Initialize array and set dimensions
        int[][] table;
        table = new int[i][j];
       
        //Calculates numbers in pascal's triangle and places them in the array
        for (int k = 0; k < i; k++){
            table[k][0] = 1;
        }
        for (int n = 0; n < j; n++){
            table[0][n] = 1;
        }

        if (i > 1 && j > 1){
            for (int k = 1; k < i; k++){
                for (int n = 1; n < j; n++){
                    table[k][n] = (table[k - 1][n] + table[k][n - 1]);
                }
            }
        
        }
        //Initializes variables that write to file 'pascal.txt'
        BufferedWriter myWriter = new BufferedWriter(new FileWriter("pascalOut.txt"));
        
        for (int k = 0; k < i; k++){
            for (int n = 0; n < j; n++){

                //Writes numbers from the array
                myWriter.write(Integer.toString(table[k][n]));

                //Write commas to separate the numbers
                if (n < j - 1){
                    myWriter.write(",");
                }
            }
            //Creates a new row
            myWriter.write('\n');
        }
        //Close file
        myWriter.close();
    }

}
