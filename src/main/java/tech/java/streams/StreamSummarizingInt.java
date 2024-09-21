package tech.java.streams;

import java.util.List;
import java.util.stream.Collectors;

public class StreamSummarizingInt {

  public static void main (String[] args) {
    var numbers = List.of (4, 21, 62, 92, 822, 0, -23, 91);

    var maxNumber1 = numbers.stream ().max (Integer::compareTo);
    var intSummaryStatistics = numbers.stream ().collect (
        Collectors.summarizingInt (value -> value));

    System.out.println (maxNumber1.isPresent () ? maxNumber1.get () : "Not found!");
    System.out.println (
        intSummaryStatistics.getMax () + ","
        + intSummaryStatistics.getMin () + ","
        + intSummaryStatistics.getSum ());
  }
}
