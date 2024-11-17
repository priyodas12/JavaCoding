package tech.java.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicatesInArray {

  public static void main(String[] args) {
    var arr = new int[]{1, 2, 3, 4, 5, 6, 7, 5, 9, 10, 3};

    var duplicates = getDuplicates(arr);
    //getIntegers(arr);

    System.out.println(duplicates);
  }

  private static Set<Integer> getIntegers(int[] arr) {
    Map<Integer, Integer> duplicateMapping = new HashMap<Integer, Integer>();

    Arrays.stream(arr)
        .forEach(num -> duplicateMapping
            .put(num, duplicateMapping.getOrDefault(num, 0) + 1));

    System.out.println(duplicateMapping);

    var duplicates = duplicateMapping
        .keySet()
        .stream()
        .filter(i -> duplicateMapping.get(i) > 1)
        .collect(Collectors.toSet());
    return duplicates;
  }

  private static Set<Integer> getDuplicates(int[] arr) {
    Map<Integer, Long> integerMap = Arrays.stream(arr)
        .boxed()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    return integerMap.keySet().stream().filter(i -> integerMap.get(i) > 1)
        .collect(Collectors.toSet());
  }
}
