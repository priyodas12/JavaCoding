package tech.java.streams.operations;

import java.util.List;
import java.util.Optional;

public class ReduceImpl {

  public static void main(String[] args) {
    //find longest string
    var randomStrList = List.of("seed1", "seed32", "12seed3", "6seed234", "seed3335", "seed");

    Optional<String> optionalStr = randomStrList
        .stream()
        .reduce((a, b) -> a.length() >= b.length() ? a : b);

    System.out.println(optionalStr.orElse(""));
  }

}
