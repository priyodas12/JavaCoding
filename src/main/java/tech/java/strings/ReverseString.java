package tech.java.strings;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseString {

  public static void main (String[] args) {
    Scanner scn = new Scanner (System.in);
    System.out.println ("Enter Any String:: ");
    var inputString = scn.next ();

    System.out.println ("Using StringBuffer:: " + getReversedString (inputString));

    System.out.println ("Using Stream:: " + getReverseStringByStream (inputString));
  }

  public static String getReversedString (String input) {
    return new StringBuffer (input).reverse ().toString ();
  }

  public static String getReverseStringByStream (String input) {
    return IntStream.range (0, input.length ())
        .mapToObj (i -> input.charAt (input.length () - i - 1))
        .map (String::valueOf)
        .collect (Collectors.joining ());
  }
}
