package tech.java.streams.problems;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public class _02DuplicateFrequency {

  public static void main(String[] args) {
    var intWithDuplicates = List.of(1, 3, 4, 5, 4, 2, 1, 3, 5, 6, 8);

    var entryMap = intWithDuplicates.stream()
        .collect(Collectors.groupingBy(num -> num, Collectors.counting()));

    entryMap.keySet()
        .parallelStream()
        .filter(num -> entryMap.get(num) > 1)
        .collect(Collectors.toCollection(LinkedHashSet::new))
        .forEach(System.out::println);
  }

}
