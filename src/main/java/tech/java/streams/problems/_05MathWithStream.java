package tech.java.streams.problems;

import java.util.List;

public class _05MathWithStream {

  public static void main(String[] args) {

    var numbers = List.of(1, 8, 4, 6, 2, -8, 6, 14);

    var max = numbers.stream().max(Integer::compareTo);

    var min = numbers.stream().min(Integer::compareTo);

    var avg = numbers.stream().mapToInt(i -> i).average();

    System.out.println(max.orElseThrow(() -> new RuntimeException("Maximum value NotFound")));

    System.out.println(min.orElseThrow(() -> new RuntimeException("Minimum value NotFound")));

    System.out.println(avg.orElseThrow(() -> new RuntimeException("Avg value NotFound")));
  }

}
