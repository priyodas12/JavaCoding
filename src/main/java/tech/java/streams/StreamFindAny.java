package tech.java.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamFindAny {

  /**
   * the findAny() method allows us to find any element from a Stream. We use it when we’re looking
   * for an element without paying an attention to the encounter order. The method returns an
   * Optional instance, which is empty if the Stream is empty
   */

  public static void main (String[] args) {
    List<String> list = Arrays.asList ("A", "AB", "C", "DA", "AZ");

    Optional<String> result = list
        .parallelStream ()
        .filter (word -> word.startsWith ("A"))
        .findAny ();

    System.out.println (result.isPresent ());
    System.out.println (result.get ());
  }
}
