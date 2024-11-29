package tech.java.streams.problems;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _01RemoveDuplicatesFromArray {

  public static void main(String[] args) {
    //declare an array
    var intWithDuplicates = List.of(1, 3, 4, 5, 4, 2, 1, 3, 5, 6, 8).toArray(Integer[]::new);

    System.out.println(new HashSet<Integer>(List.of(intWithDuplicates)));

    var duplicates = Stream.of(intWithDuplicates)
        .filter(num -> Collections.frequency(List.of(intWithDuplicates), num) > 1)
        .collect(Collectors.toSet());

    System.out.println(duplicates);

    //from word
    String str = "priyobrato";

    var res = str.chars().mapToObj(c -> String.valueOf((char) c)).collect(Collectors.toSet());

    System.out.println(res);

    //from sentence
    String str2 = "Stream this sentence into a list of words";
    var wordMap = Arrays.stream(str2.split(" ")).sequential()
        .collect(Collectors.groupingBy(st -> st, Collectors.counting()));

    System.out.println(wordMap);

  }

}
