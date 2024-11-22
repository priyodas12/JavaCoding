package tech.java.threads;

public class DeadLockExample {

  private static final Object resource1 = new Object();
  private static final Object resource2 = new Object();

  public static void main(String[] args) {

    Thread thread1 = new Thread(() -> {
      synchronized (resource1) {
        System.out.println("Thread 1: Locked resource 1");

        try {
          System.out.println("Thread 1: working on resource 1");
          Thread.sleep(1000);
        } catch (InterruptedException e) {
        }

        synchronized (resource2) {
          System.out.println("Thread 1: Locked resource 2");
        }
      }
    });

    // Thread 2: Locks resource2, then tries to lock resource1
    Thread thread2 = new Thread(() -> {
      synchronized (resource2) {
        System.out.println("Thread 2: Locked resource 2");

        try {
          System.out.println("Thread 1: working on resource 2");
          Thread.sleep(1000);
        } catch (InterruptedException e) {
        }

        synchronized (resource1) {
          System.out.println("Thread 2: Locked resource 1");
        }
      }
    });

    thread1.start();
    thread2.start();
  }
}
