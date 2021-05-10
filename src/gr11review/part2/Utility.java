package gr11review.part2;
import java.io.*;
import java.util.Scanner;
public class Utility {

/**
* This method zipZap lets the user specify a String
* and removes the middle character within a 3 letter string in the pattern
* z_p, wherever this is found
*
* @param str  The String which the program searches for instances of 'z_p'
* @return A string with the middle character removed from instances of 'z_p'
* @author Natalia Garcia-Arias
*/
    public static String zipZap(String str){

        String strNew;

        //Removes all letters between the pattern "z_p"
        strNew = str.replaceAll("z[a-zA-Z]p", "zp");
        
        return strNew;
    } 

/**
* This method longestWord searches for the longest word in
* a file specified by the user and returns such word.
*
* @param filenametxt  The name of a file containing a single word on each line
* @return A string containing the longest word in the specified file
* @author Natalia Garcia-Arias
*/
    public static String longestWord(String filenametxt){
        
        //Initializes variables
        String longestWord = "";
        String currentWord;
        
        //Scans file for the longest word
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

/**
* This method tenRun lets the user specify a one-dimensional array 
* and changes all the values following a multiple of 10 to be that multiple
* until the next multiple of 10 is encountered.
*
* @param nums The one-dimensional array specified by the user 
* @return The array with all non multiples of 10 replaced by multiples of 10
* @author Natalia Garcia-Arias
*/
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

/**
* This method linearIn lets the user specify two one-dimensional arrays
* sorted in increasing order,
* and returns a true boolean value if all numbers in inner appear 
* in outer
*
* @param inner  The inner array who's elements are checked for in the outer array
* @param outer  The outer array which is checked for the elements in the inner array
* @return boolean value 
* @author Natalia Garcia-Arias
*/
    public static boolean linearIn(int[] outer, int[] inner){

        //Initialize variables
        int d = 0;
        int match = 0;
       
        if ( inner.length == 0){
            return true;
        }
        for (int i = 0; i < outer.length; i++){
           //Counts when there is a match in values from inner with outer
            if (outer[i] == inner[d]){
                match++;
                d++;
            } else if (outer[i] > inner[d]){
                return false;
            }

            //Returns true the number of found values matches length of inner
            if (match == inner.length){
                return true;
            } 
        }

        return false;
    }
/**
* This method pascalTri outputs to a text file a comma-separated table
* containing a number of 'i' rows and 'j' columns of pascal's triangle. 
*
* @param i  number of rows in the table
* @param j  number of columns in the table
* @author Natalia Garcia-Arias
*/
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
        BufferedWriter myWriter = new BufferedWriter(new FileWriter("src/gr11review/part2/pascalOut.txt"));
        
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
