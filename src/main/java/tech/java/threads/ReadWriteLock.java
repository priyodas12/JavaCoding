package tech.java.threads;

import java.time.Instant;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.IntStream;

public class ReadWriteLock {

  private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
  AtomicInteger sharedAtomicInt = new AtomicInteger(1);

  public static void main(String[] args) {
    IntStream.rangeClosed(1, 15).forEach(i -> {
      new Thread(() -> {
        new ReadWriteLock().readResource();
      }).start();
    });

    IntStream.rangeClosed(1, 5).forEach(i -> {
      new Thread(() -> {
        new ReadWriteLock().writeResource();
      }).start();
    });
  }

  private void readResource() {
    try {
      lock.readLock().lock();
      Thread.sleep(1000);
      System.out.println(sharedAtomicInt.get() +
          " >> Reading resource at: " + Instant.now() + ", by: " + Thread.currentThread()
          .getName());
    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally {
      lock.readLock().unlock();
    }
  }

  private void writeResource() {
    try {
      lock.writeLock().lock();
      sharedAtomicInt.getAndIncrement();
      Thread.sleep(1000);
      System.out.println(sharedAtomicInt.get() +
          " >> Writing resource at: " + Instant.now() + ", by: " + Thread.currentThread()
          .getName());
    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally {
      lock.writeLock().unlock();
    }
  }
}
