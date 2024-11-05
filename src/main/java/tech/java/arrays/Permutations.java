package tech.java.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

  public static void main(String[] args) {

    var list = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

    var finalResult = new ArrayList<List<Integer>>();

    generatePermutations(list, 0, finalResult);

    finalResult.forEach(System.out::println);

    System.out.println(finalResult.size());
  }

  protected static void generatePermutations(
      List<Integer> integerList, int index,
      List<List<Integer>> permutaionList) {

    if (index == integerList.size() - 1) {
      permutaionList.add(new ArrayList<>(integerList));
      return;
    }
    for (int m = index; m < integerList.size(); m++) {
      swap(integerList, index, m);
      generatePermutations(integerList, index + 1, permutaionList);
      swap(integerList, index, m);
    }
  }

  private static void swap(List<Integer> integerList, int i, int j) {
    int temp = integerList.get(i);
    integerList.set(i, integerList.get(j));
    integerList.set(j, temp);
  }
}
