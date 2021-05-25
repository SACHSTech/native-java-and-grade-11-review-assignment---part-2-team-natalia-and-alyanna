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

 // Methods 2
  public static int sumNumbers(String str) {

    // Initialize variables
    int intCharacters = str.length();
    String strNumber = "";
    int intSumOfNumbers = 0;

    // Loop through each character of input
    for (int intI = 0; intI < intCharacters; intI++) {
      
      char charCurrent = str.charAt(intI);

      if (Character.isDigit(charCurrent)) {
        strNumber = charCurrent + "";

        for (int intJ = intI + 1; intJ < intCharacters; intJ++) {

          char charNext = str.charAt(intJ);
          if (Character.isDigit(charNext)) {
            strNumber = strNumber + charNext;
          } else {
            break;
          }                  
           
          intI = intJ;
        } // end of inner for loop
      } 

      if (!strNumber.equals("")) {
        intSumOfNumbers = intSumOfNumbers + Integer.parseInt(strNumber);
        strNumber = "";
      }

    } // end of outer for loop

    return intSumOfNumbers;
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
 
  // File IO - Read 2
  public static String alphaWord(String filenametxt) {

    // Initialize variables
    StringBuilder contentBuilder = new StringBuilder();
    String strCurrentWord = null;
    String strFirstWord = null;

    // Open file and read line by line
    try (BufferedReader br = new BufferedReader(new FileReader(filenametxt))) {
        
      while ((strCurrentWord = br.readLine()) != null) {
        
        if (strFirstWord == null) {
          strFirstWord = strCurrentWord;
        } else if (strCurrentWord.compareTo(strFirstWord) < 0) {
          strFirstWord = strCurrentWord;
        }

      }

    } catch (IOException e) {
      e.printStackTrace();
    }

    return strFirstWord;
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
// Array 2 - One Dimensional
  public static int[] notAlone(int[] nums, int value) {

    // Initialize variables
    int[] result = new int[nums.length];

    for (int intX = 0; intX < nums.length; intX++) {

      if (intX == 0 || intX == (nums.length - 1)) {
        result[intX] = nums[intX];
      } else {
        int intBeforeValue = nums[intX - 1];
        int intAfterValue = nums[intX + 1];
        int intCurrentValue = nums[intX];

        result[intX] = intCurrentValue;

        // Input given value is equal to the current value
        if (intCurrentValue == value) {
          // Check whether before or after value is greater
          if (intBeforeValue >= intAfterValue) {
            // Check whether before value is greater than the current value
            if (intBeforeValue > intCurrentValue) {
              result[intX] = intBeforeValue;
            }
          } else { 
            // Check whether after value is greater than the current value
            if (intAfterValue > intCurrentValue) {
              // Use after value
              result[intX] = intAfterValue;
            }
          }
        }
      }
    }

    return result;
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
  
   // Array 4 - One Dimensional - Two Loops
  public static boolean canBalance(int[] nums) {

    // Initialize variables
    int intSum = 0;
    int intSumOfLeftSide = 0;
    int intSumOfRightSide = 0;

    // Get total sum of full array
    for (int intX = 0; intX < nums.length; intX++) {
      intSum = intSum + nums[intX];
    }

    intSumOfRightSide = intSum;

    // Find balance of numbers
    for (int intY = 0; intY < nums.length; intY++) {
      intSumOfLeftSide = intSumOfLeftSide + nums[intY];
      intSumOfRightSide = intSumOfRightSide - nums[intY];

      if (intSumOfLeftSide == intSumOfRightSide) {
        // Return true if numbers balance
        return true;
      }
    }

    // Return false if numbers don't balance
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
  
   // Array 6 - Two Dimensional
  public static void diagonal(int n) throws IOException {

    // Initialize variables
    int[][] result = new int[n][n];
    int intOnePosition = n - 1;

    // Derive values for two dimensional array
    for (int intX = 0; intX < n; intX++) {
      for (int intY = 0; intY < n; intY++ ) {
        
        if (intY < intOnePosition) {
          result[intX][intY] = 0;
        } else if (intY == intOnePosition) {
          result[intX][intY] = 1;
        } else {
          result[intX][intY] = 2;
        }
      } // end of inner loop

      intOnePosition--;

    } // end of outer loop 
    
    //PrintWriter pw = new PrintWriter(new FileWriter("resource/diagonalOut.txt"));
    PrintWriter pw = new PrintWriter(new FileWriter("diagonalOut.txt"));
 
    // Initialize variables
    String strOutput = "";

    // Write to the output file
    for (int intX = 0; intX < n; intX++) {
      for (int intY = 0; intY < n; intY++ ) {

        if (intY == (n - 1)) {
          strOutput = strOutput + result[intX][intY];
        } else {
          strOutput = strOutput + result[intX][intY] + ",";
        }
	    } // end of inner loop

		  pw.write(strOutput + "\n");
      strOutput = "";
    } // end of outer loop
 
	  pw.close();
  }

}
