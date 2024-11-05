package tech.java.streams;

import java.util.HashMap;
import java.util.random.RandomGenerator;
import java.util.stream.Stream;

public class StreamToMap {

  public static void main(String[] args) {
    var result = Stream.iterate(1, i -> i * RandomGenerator.getDefault().nextInt(1, 10))
        .peek(System.out::println)
        .limit(10).toList();
    //.collect(Collectors.toMap(i -> i, Function.identity(), (existing, replacement) -> replacement));
    System.out.println(result);

    var testMap = new HashMap<Integer, Integer>();

    result.forEach(i -> testMap.put(i, testMap.getOrDefault(i, 0) + 1));

    System.out.println(testMap);
  }

}
