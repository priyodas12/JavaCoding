package tech.java.strings;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CountVowelInString {

  public static void main (String[] args) {
    Scanner scn = new Scanner (System.in);
    System.out.println ("Enter Any String:: ");
    var inputString = scn.next ();

    System.out.println ("Total Vowel with repeat:: " + getVowelCount (inputString));

    System.out.println ("Get Vowel Count:: " + (long) getVowelCount (inputString).keySet ()
        .size ());
  }

  private static Map<String, Integer> getVowelCount (String input) {

    return IntStream.range (0, input.length ())
        .mapToObj (input::charAt)
        .filter (l -> List.of ("a", "e", "i", "o", "u").contains (String.valueOf (l)))
        .map (String::valueOf)
        .collect (Collectors.toMap (Function.identity (), e -> 1, Integer::sum
                                   ));
  }
}
