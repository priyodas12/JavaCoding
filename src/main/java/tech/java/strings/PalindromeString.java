package tech.java.strings;

import java.util.Scanner;
import java.util.stream.IntStream;

public class PalindromeString {

  public static void main (String[] args) {
    Scanner scn = new Scanner (System.in);
    System.out.println ("Enter Any String:: ");
    var inputString = scn.next ();

    System.out.println ("Is Palindrome:: " + isPalindrome (inputString.toLowerCase ()));
    

  }

  private static boolean isPalindrome (String inputStr) {
    return IntStream.range (0, inputStr.length () / 2).allMatch (
        i -> inputStr.charAt (i) == inputStr.charAt (inputStr.length () - i - 1));
  }
}
