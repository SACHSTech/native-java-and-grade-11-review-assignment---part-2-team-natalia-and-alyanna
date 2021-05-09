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

}
