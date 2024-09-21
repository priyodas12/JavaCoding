package tech.java.streams;

import java.util.List;
import java.util.stream.Collectors;

public class StreamWithPartitioningBy {

  public static void main (String[] args) {

    var stringList = List.of (
        "one", "two", "three", "four", "five", "six", "seven", "eight", "nine");

    var partitionByLength1 =
        stringList.stream ().collect (Collectors.partitioningBy (s -> s.length () > 4));

    System.out.println (
        partitionByLength1);//{false=[one, two, four, five, six, nine], true=[three, seven, eight]}

    var partitionByLength2 =
        stringList.stream ().collect (
            Collectors.partitioningBy (
                s -> s.length () > 4,
                Collectors.counting ()
                                      ));

    System.out.println (
        partitionByLength2);//{false=6, true=3}
  }
}
