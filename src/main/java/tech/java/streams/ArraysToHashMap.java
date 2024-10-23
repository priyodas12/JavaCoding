package tech.java.streams;

import java.util.Arrays;
import java.util.HashMap;

public class ArraysToHashMap {

  public static void main (String[] args) {

    var arr = new int[]{1, 4, 5, 6, 6, 7, 9, 1, 4, 2, 4, 8};

    var intMap1 = new HashMap<Integer, Integer> ();
    var intMap2 = new HashMap<Integer, Integer> ();

    // get or default
    Arrays.stream (arr).boxed ().forEach (
        i -> intMap1.put (i, intMap1.getOrDefault (i, 0) + 1));

    intMap1.forEach ((k, v) -> {
      System.out.printf (" '%d' --> %d \n", k, v);
    });
    System.out.println ("-----------------------------");
    Arrays.stream (arr).boxed ().forEach (i ->
                                              intMap2.compute (i, (key, val) -> val == null ? 1
                                                  : val + 1)
                                         );
    intMap2.forEach ((k, v) -> {
      System.out.printf (" '%d' --> %d \n", k, v);
    });
  }
}
