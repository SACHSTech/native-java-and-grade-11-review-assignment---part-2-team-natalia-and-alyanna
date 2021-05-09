package gr11review.part2;

import java.io.*;

public class Utility {

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

}
