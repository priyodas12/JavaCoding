package tech.java.streams;

import java.util.Arrays;
import java.util.HashMap;

public class ArraysToHashMap {

  public static void main (String[] args) {

    var arr = new int[]{1, 4, 5, 6, 6, 7, 9, 1, 4, 2, 4, 8};

    var intMap1 = new HashMap<Integer, Integer> ();
    var intMap2 = new HashMap<Integer, Integer> ();
    var intMap3 = new HashMap<Integer, Integer> ();

    System.out.println ("------------getOrDefault-----------------");
    // get or default
    Arrays.stream (arr).boxed ().forEach (
        i -> intMap1.put (i, intMap1.getOrDefault (i, 0) + 1));

    intMap1.forEach ((k, v) -> {
      System.out.printf (" '%d' --> %d \n", k, v);
    });

    System.out.println ("------------compute-----------------");
    // compute
    Arrays.stream (arr).boxed ().forEach (i ->
                                              intMap2.compute (i, (key, val) -> val == null ? 1
                                                  : val + 1)
                                         );
    intMap2.forEach ((k, v) -> {
      System.out.printf (" '%d' --> %d \n", k, v);
    });

    System.out.println ("------------computeIfAbsent-----------------");
    // compute if absent
    Arrays.stream (arr).boxed ().forEach (
        i -> {
          intMap3.computeIfAbsent (i, key -> 0);
          intMap3.compute (i, (key, val) -> {
            System.out.println ("computing: " + key + "->" + val);
            return (val + 1);
          });
        });

    intMap3.forEach ((k, v) -> {
      System.out.printf (" '%d' --> %d \n", k, v);
    });
  }
}
