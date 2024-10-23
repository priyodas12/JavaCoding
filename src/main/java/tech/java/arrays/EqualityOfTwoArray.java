package tech.java.arrays;

import java.util.Arrays;

public class EqualityOfTwoArray {

  public static void main (String[] args) {

    var arr1 = new int[]{1, 4, 7, 8};

    var arr2 = new int[]{8, 4, 1, 7};

    System.out.println (isMatch (arr1, arr2));
  }

  private static boolean isMatch (int[] arr1, int[] arr2) {

    if (arr1.length == arr2.length) {
      return Arrays.stream (arr1).allMatch (
          elem -> Arrays.stream (arr2).filter (e -> e == elem).count () ==
                  Arrays.stream (arr1).filter (e -> e == elem).count ()
                                           );
    }
    return false;
  }
}
