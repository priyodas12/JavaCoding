package tech.java.streams;

import java.util.List;
import java.util.stream.Collectors;

public class StreamGroupingBy {

  /**
   * group by with string length and joining
   */

  public static void main (String[] args) {
    var randomStringList = List.of ("AAA", "AA", "AAA", "BBB", "A", "CCCCC");

    var groupByElements1 = randomStringList
        .stream ()
        .collect (Collectors.groupingBy (String::length));

    var groupByElements2 = randomStringList
        .stream ()
        .collect (
            Collectors.groupingBy (String::length, Collectors.joining ("*")));

    groupByElements1.forEach ((k, v) -> System.out.println (k + " >> " + v));
    /**
     * 1 >> [A]
     2 >> [AA]
     3 >> [AAA, AAA, BBB]
     5 >> [CCCCC]
     */
    groupByElements2.forEach ((k, v) -> System.out.println (k + " >> " + v));
    /**
     1 >> A
     2 >> AA
     3 >> AAA*AAA*BBB
     5 >> CCCCC
     */
  }
}
