package tech.java.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class DiscoverPermutationWithString {

  private static List<String> generatePermutations (String input) {
    if (input.isEmpty ()) {
      return List.of ("");
    }

    return IntStream.range (0, input.length ())
        .boxed ()
        .flatMap (i -> generatePermutations (input.substring (0, i) + input.substring (i + 1))
            .stream ()
            .map (permutation -> input.charAt (i) + permutation))
        .toList ();
  }

  private static void permute (char[] array, int index, List<String> result) {
    if (index == array.length - 1) {
      result.add (new String (array));
      return;
    }

    for (int i = index; i < array.length; i++) {
      swap (array, i, index);
      permute (array, index + 1, result);
      swap (array, i, index);
    }
  }

  private static void swap (char[] array, int i, int j) {
    char temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

  public static void main (String[] args) {
    Scanner scn = new Scanner (System.in);
    System.out.println ("Enter Any String:: ");
    var inputString = scn.next ();

    //List<String> permutations = generatePermutations (inputString);

    //System.out.println (permutations);

    List<String> result = new ArrayList<> ();
    
    permute (inputString.toCharArray (), 0, result);

    System.out.println (result);
  }
}
