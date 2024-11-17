package tech.java.arrays;

import java.util.Arrays;

public class SortedArrayMerge {

  public static void main(String[] args) {
    var arr1 = new int[]{1, 3, 4, 5, 6};
    var arr2 = new int[]{2, 7, 9, 15, 26};

    int[] mergeSorted = merge(arr1, arr2);

    System.out.println(Arrays.toString(mergeSorted));
  }

  private static int[] merge(int[] arr1, int[] arr2) {
    return Arrays.stream(new int[][]{arr1, arr2}).flatMapToInt(Arrays::stream).sorted().toArray();
  }
}
