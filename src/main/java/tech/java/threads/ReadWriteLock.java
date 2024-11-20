package tech.java.threads;

import java.time.Instant;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLock {

  private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
  private String sharedResource = "Initial Value";

  public static void main(String[] args) {
    ReadWriteLock example = new ReadWriteLock();

    Runnable readTask = () -> {
      for (int i = 0; i < 10; i++) {
        example.readResource();
        try {
          Thread.sleep(100); // Simulate read delay
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
        }
      }
    };

    Runnable writeTask = () -> {
      for (int i = 0; i < 3; i++) {
        example.writeResource("New Value " + i);
        try {
          Thread.sleep(300); // Simulate write delay
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
        }
      }
    };

    Thread reader1 = new Thread(readTask, "Reader-1");
    Thread reader2 = new Thread(readTask, "Reader-2");
    Thread writer = new Thread(writeTask, "Writer");

    reader1.start();
    reader2.start();
    writer.start();
  }

  public String readResource() {
    lock.readLock().lock(); // Acquire read lock
    try {
      System.out.println(
          Thread.currentThread().getName() + " reading: " + sharedResource + ", Time: "
              + Instant.now().getNano());
      return sharedResource;
    } finally {
      lock.readLock().unlock(); // Release read lock
    }
  }

  public void writeResource(String newValue) {
    lock.writeLock().lock(); // Acquire write lock
    try {
      Thread.sleep(200);
      System.out.println("------------------->" +
          Thread.currentThread().getName() + " writing: " + newValue + ", Time: " + Instant.now()
          .getNano());
      sharedResource = newValue;
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    } finally {
      lock.writeLock().unlock(); // Release write lock
    }
  }
}
