package tech.java.streams.problems;

import java.util.Arrays;
import java.util.Comparator;

public class _03SortingOfString {

  public static void main(String[] args) {

    //ascending and descending order
    String str2 = "Stream this sentence into aq list of words";

    var res1 = Arrays.stream(str2.toLowerCase().split(" "))
        .sorted(Comparator.naturalOrder())
        .toList();

    System.out.println(res1);

    //sorting by word length
    var res2 = Arrays.stream(str2.toLowerCase().split(" "))
        .sorted(Comparator.comparing(s -> s.charAt(1)))
        .toList();

    System.out.println(res2);

  }
}
