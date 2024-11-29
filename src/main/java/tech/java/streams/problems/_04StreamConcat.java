package tech.java.streams.problems;

import java.util.List;
import java.util.stream.Stream;

public class _04StreamConcat {

  public static void main(String[] args) {
    var input1 = List.of("z", "a", "v", "i");

    var input2 = List.of("y", "o", "m", "g");

    var concated = Stream.concat(input1.stream(), input2.stream()).sorted().toList();

    System.out.printf("Concated Stream: %s\n", concated);
  }

}
