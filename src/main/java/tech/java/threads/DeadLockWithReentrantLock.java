package tech.java.threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockWithReentrantLock {

  private static final Lock lock1 = new ReentrantLock();
  private static final Lock lock2 = new ReentrantLock();

  public static void main(String[] args) {

    // Thread 1
    Thread thread1 = new Thread(() -> {
      try {
        lock1.lock();
        System.out.println("Thread 1: Locked resource 1");

        Thread.sleep(100);

        lock2.lock();
        System.out.println("Thread 1: Locked resource 2");
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        lock2.unlock();
        lock1.unlock();
      }
    });

    Thread thread2 = new Thread(() -> {
      try {
        lock1.lock();
        System.out.println("Thread 2: Locked resource 1");

        Thread.sleep(100);

        lock2.lock();
        System.out.println("Thread 2: Locked resource 2");
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        lock2.unlock();
        lock1.unlock();
      }
    });

    thread1.start();
    thread2.start();
  }
}
