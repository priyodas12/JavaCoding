package tech.java.threads;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class LeaderElection {

  private static final ReentrantLock lock = new ReentrantLock();

  public static void main(String[] args) {

    for (int i = 1; i <= 5; i++) {
      ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(5);
      Thread t = new Thread(new Worker(i, lock));
      scheduler.scheduleAtFixedRate(t, 0, 6, TimeUnit.SECONDS);
    }
  }
}
