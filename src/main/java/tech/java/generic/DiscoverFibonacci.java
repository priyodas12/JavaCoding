package tech.java.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class DiscoverFibonacci {

  private static List<Integer> generateFibonacci(int upperLimit) {
    List<Integer> list = new ArrayList<>();
    for (int i = 1; i <= upperLimit; i++) {
      var num = fibonacci(i);
      list.add(num);
    }
    return list;
  }

  private static int fibonacci(int n) {
    if (n <= 1) {
      return n;
    }
    return fibonacci(n - 1) + fibonacci(n - 2);
  }

  public static void main(String[] args) {

    //System.out.println(generateFibonacci(42));

    var listOfFibonacci = IntStream.range(1, 20)
        .boxed()
        .map(DiscoverFibonacci::fibonacci)
        .toList();

    System.out.println(listOfFibonacci);
  }
}
