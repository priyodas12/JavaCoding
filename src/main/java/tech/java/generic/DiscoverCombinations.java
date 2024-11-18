package tech.java.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DiscoverCombinations {

  public static void main(String[] args) {
    var arr = new int[]{1, 2, 3};
    //[],[1],[2],[3],[1,2],[2,3],[1,3],[1,2,3]
    var results = IntStream.range(1, 1 << arr.length)
        .mapToObj(i -> IntStream.range(0, arr.length)
            .filter(j -> (i & (1 << j)) != 0)
            .mapToObj(j -> arr[j])
            .collect(Collectors.toSet()))
        .collect(Collectors.toSet());

    System.out.println(results);

    List<List<Integer>> powerSet = new ArrayList<>();
    generatePowerSet(arr, 0, new ArrayList<>(), powerSet);

    System.out.println("Power Set: " + powerSet);
  }

  private static void generatePowerSet(
      int[] arr,
      int index,
      List<Integer> current,
      List<List<Integer>> result) {
    
    result.add(new ArrayList<>(current));

    for (int i = index; i < arr.length; i++) {
      current.add(arr[i]);
      generatePowerSet(arr, i + 1, current, result);
      current.removeLast();
    }
  }
}
