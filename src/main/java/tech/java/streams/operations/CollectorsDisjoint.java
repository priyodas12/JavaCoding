package tech.java.streams.operations;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

//no common element between two collection
public class CollectorsDisjoint {

  public static void main(String[] args) {
    var list1 = List.of(1, 2, 3, 4, 5, 9, 2, 4, 7, 6, 7, 8);

    var list2 = List.of(1, 2, 3, 4, 5, 9, 2, 4, 7, 6, 7, 8);

    System.out.println(Collections.disjoint(list1, list2));

    //equality check
    var result = IntStream.range(0, list1.size()).allMatch(i -> Objects.equals(list1.get(i),
        list2.get(i)));

    System.out.println(result);

  }
}
