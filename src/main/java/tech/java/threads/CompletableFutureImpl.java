package tech.java.threads;

import java.time.Instant;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureImpl {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(() -> {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      return "" + UUID.randomUUID();
    });

    CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(() -> {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      return "" + Instant.now().toEpochMilli();
    });

    var res1 = completableFuture1.thenCombine(completableFuture2, (a, b) -> a + " : " + b);

    var res2 = CompletableFuture.allOf(completableFuture1, completableFuture2);

    res1.join();
    res2.join();

    System.out.println(res1.get());
    System.out.println(res2.get());

    ExecutorService executorService = Executors.newFixedThreadPool(8);

    CompletableFuture.supplyAsync(() -> "\n1: " +
            Thread.currentThread().getName(), executorService)
        .thenApplyAsync(result -> result + "\n2: " + Thread.currentThread().getName(),
            executorService)
        .thenApplyAsync(result -> result + "\n3: " + Thread.currentThread().getName(),
            executorService)
        .thenAcceptAsync(System.out::println);


  }

}
