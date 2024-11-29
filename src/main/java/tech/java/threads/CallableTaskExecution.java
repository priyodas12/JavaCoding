package tech.java.threads;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class CallableTaskExecution {

  public static void main(String[] args) {

    ExecutorService executorService = Executors.newFixedThreadPool(10);

    Callable<String> callableTask = () -> UUID.randomUUID() + ":" + Instant.now().toEpochMilli();

    List<Future<String>> futures = new ArrayList<>();

    IntStream.range(0, 20).forEach(_ -> {
      futures.add(executorService.submit(callableTask));
    });

    futures.forEach(uuidFuture -> {
      try {
        Thread.sleep(100);
        System.out.println(uuidFuture.get());
      } catch (Exception e) {
        throw new RuntimeException(e);
      } finally {
        executorService.shutdown();
      }
    });
  }
}
