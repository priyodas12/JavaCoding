package tech.java.generic;

import java.util.Scanner;
import java.util.stream.IntStream;

public class DiscoverPrimeNumber {

  public static void main (String[] args) {
    Scanner scn = new Scanner (System.in);

    System.out.println ("Enter Any Number:: ");

    var input = scn.nextInt ();

    System.out.println (Math.sqrt (35));

    System.out.println (input + " is prime ? \n Answer: " + isPrime (input));

  }

  private static boolean isPrime (int number) {
    if (number < 2) {
      return false;
    }
    return IntStream.rangeClosed (2, (int) Math.sqrt (number)).noneMatch (n -> number % n == 0);
  }
}
