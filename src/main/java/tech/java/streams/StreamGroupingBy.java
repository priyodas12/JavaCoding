package tech.java.streams;

import java.util.List;
import java.util.stream.Collectors;

public class StreamGroupingBy {

  /**
   * group by with string length
   */

  public static void main (String[] args) {
    var randomStringList = List.of ("AAA", "AA", "AAA", "BBB", "AAA", "C");

    var groupByElements = randomStringList
        .stream ()
        .collect (Collectors.groupingBy (String::length));

    groupByElements.forEach ((k, v) -> System.out.println (k + " >> " + v));
  }
}
