package tech.java.streams.operations;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectorsFrequency {

  public static void main(String[] args) {
    var list = List.of(1, 2, 3, 4, 5, 9, 2, 4, 7, 6, 7, 8);

    list.stream()
        .filter(num -> Collections.frequency(list, num) > 1)
        .collect(Collectors.toSet())
        .forEach(System.out::println);

    var numMap = list.stream()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    System.out.println(numMap);
  }
}
