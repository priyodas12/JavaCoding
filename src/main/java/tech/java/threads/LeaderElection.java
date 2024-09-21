package tech.java.threads;

import java.util.concurrent.locks.ReentrantLock;

public class LeaderElection {

  private static final ReentrantLock lock = new ReentrantLock ();
  private static Thread leaderThread = null;

  public static void main (String[] args) {
    for (int i = 1; i <= 5; i++) {
      Thread t = new Thread (new Worker (i));
      t.start ();
    }
  }

  static class Worker implements Runnable {

    private final int id;

    public Worker (int id) {
      this.id = id;
    }

    @Override
    public void run () {
      try {
        if (lock.tryLock ()) {
          if (leaderThread == null) {
            leaderThread = Thread.currentThread ();
            System.out.println ("Thread " + id + " is the leader.");
          }
        } else {
          System.out.println ("Thread " + id + " did not become the leader.");
        }
      } finally {
        if (Thread.currentThread () == leaderThread) {
          lock.unlock ();
        }
      }
    }
  }
}
