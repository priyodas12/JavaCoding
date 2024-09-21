package tech.java.streams;

import java.util.stream.IntStream;

public class NumberCombinations {

  public static void main (String[] args) {
    var numbers = new int[]{1, 2, 3, 4, 5, 6};

    IntStream.range (0, numbers.length)
        .boxed ()
        .flatMapToInt (i -> IntStream.range (i + 1, numbers.length))
        .asLongStream ()
        .forEach (System.out::println);
  }
}
