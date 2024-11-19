package tech.java.threads;

import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class Worker implements Runnable {

  private static Thread leaderThread = null;

  private final int id;
  private final ReentrantLock lock;

  public Worker(int id, ReentrantLock lock1) {
    this.id = id;
    this.lock = lock1;
  }

  @Override
  public void run() {
    try {
      if (lock.tryLock()) {
        if (leaderThread == null) {
          leaderThread = Thread.currentThread();
          System.out.println("-------------Thread " + id + " is the leader.--------------");
          executeTask();
        } else {
          System.out.println(
              "Thread " + id + " found leader already exists: " + leaderThread.getName());
        }
      } else {
        System.out.println("***********Thread " + id + " did not become the leader.***********");
      }
    } finally {
      if (Thread.currentThread() == leaderThread) {
        leaderThread = null;
        lock.unlock();
      }
    }
  }

  private void executeTask() {

    IntStream.range(0, 5).forEach(i -> {
      try {
        Thread.sleep(600);
        System.out.println("Thread " + id + " executing task " + UUID.randomUUID());
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    });
  }
}

