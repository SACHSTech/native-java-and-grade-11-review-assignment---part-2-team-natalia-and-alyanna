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
    
}
