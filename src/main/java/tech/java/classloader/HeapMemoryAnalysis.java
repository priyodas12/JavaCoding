package tech.java.classloader;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.util.ArrayList;
import java.util.List;

//javac src/main/java/tech/java/classloader/HeapMemoryAnalysis.java
//javac HeapMemoryAnalysis.java
// cd src\main\java\tech\java\classloader
//java -XX:+UseZGC -Xms2g -Xmx2g -Xlog:gc*:file=gc.log src.main.java.tech.java.classloader
// .HeapMemoryAnalysis
//java -XX:+UseZGC -Xms2g -Xmx2g -Xlog:gc*:file=gc.log tech.java.classloader.HeapMemoryAnalysis
public class HeapMemoryAnalysis {

  public static void main (String[] args) {
    List<String> listString = new ArrayList<> ();

    for (int i = 0; i < 1_00_000_000; i++) {
      String str = "Hello, World! " + i;
      listString.add (str);
    }
    System.out.println (listString.size ());
    printHeapMemoryUsage ();
  }

  //java -XX:+PrintGC -XX:+PrintGCDetails -Xms200m -Xmx500m HeapMemoryAnalysis
  private static void printHeapMemoryUsage () {
    MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean ();
    MemoryUsage heapMemoryUsage = memoryMXBean.getHeapMemoryUsage ();

    System.out.println ("Heap Memory Usage:");
    System.out.println ("  Initial: " + heapMemoryUsage.getInit () / (1024 * 1024) + " MB");
    System.out.println ("  Used: " + heapMemoryUsage.getUsed () / (1024 * 1024) + " MB");
    System.out.println ("  Committed: " + heapMemoryUsage.getCommitted () / (1024 * 1024) + " MB");
    System.out.println ("  Maximum: " + heapMemoryUsage.getMax () / (1024 * 1024) + " MB");
  }
}

