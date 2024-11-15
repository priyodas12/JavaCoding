package tech.java.lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.openjdk.jol.info.ClassLayout;

public class ListUseCases {

  public static void main(String[] args) throws Exception {
    Runtime runtime = Runtime.getRuntime();
    runtime.gc();
    var str = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    long before = runtime.totalMemory() - runtime.freeMemory();

    // Create object
    List<Integer> integerArrayList = new ArrayList<>();

    long after = runtime.totalMemory() - runtime.freeMemory();

    var consumedMb = (after - before) / (1024 * 1024);

    System.out.println("Total Memory Consumed: " + consumedMb + " MB");

    System.out.println(ClassLayout.parseInstance(str).toPrintable());

    List<Integer> integerLinkedList = new LinkedList<>();


    /*for (int i = 0; i < 11; i++) {
      integerLinkedList.add(1);
      integerArrayList.add(1);
    }*/

    System.out.println(integerArrayList.size());
    System.out.println(integerLinkedList.size());
  }
}
