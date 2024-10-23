package tech.java.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


public class StreamFindFirst {

  /**
   * The findFirst() method finds the first element in a Stream. So, we use this method when we
   * specifically want the first element from a sequence. The behavior of the findFirst method does
   * not change in the parallel scenario. If the encounter order exists, it will always behave
   * deterministically.
   */

  public static void main (String[] args) {
    List<String> list = Arrays.asList ("A", "B", "C", "D");

    Optional<String> result = list.parallelStream ().findFirst ();

    System.out.println (result.isPresent ());
    System.out.println (result.get ());

  }

  public void validateClaims () {

  }
}
