package gr11review.part2;

import java.util.Arrays;

public class Main {
  
  public static void main(String[] args) {

    // Methods 2
    System.out.println(Utility.sumNumbers("abc123xyz"));
    System.out.println(Utility.sumNumbers("aa11b33"));
    System.out.println(Utility.sumNumbers("7 11"));


    // File IO - Read 2
    System.out.println(Utility.alphaWord("resource/filenametxt.txt"));

    // Array 2 - One Dimensional
    System.out.println(Arrays.toString(Utility.notAlone(new int[]{1,2,3}, 2)));
    System.out.println(Arrays.toString(Utility.notAlone(new int[]{1,2,3,2,5,2}, 2)));
    System.out.println(Arrays.toString(Utility.notAlone(new int[]{3,4}, 3)));

  }

}