package tech.java.streams;

import java.util.stream.IntStream;

public class ParallelStreamImpl {

  public static void main(String[] args) {
    IntStream.range(0, 10).parallel()
        .forEach(i -> System.out.println(Thread.currentThread().getName()));
  }

}
