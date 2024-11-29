package tech.java.threads;

import java.time.Instant;
import java.util.stream.IntStream;

public class ForkJoinPoolExp {

  public static void main(String[] args) {

    IntStream.range(0, 20).parallel().forEach(i -> {
      System.out.println(Thread.currentThread().getName() + " >> " + Instant.now().toString());
    });
  }
}
