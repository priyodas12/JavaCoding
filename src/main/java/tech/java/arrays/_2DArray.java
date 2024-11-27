package tech.java.arrays;

import java.util.Arrays;

public class _2DArray {

  public static void main(String[] args) {
    int[][] twoDimArray = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
    
    var listArray = Arrays.stream(twoDimArray)
        .flatMap(ints -> Arrays.stream(ints).boxed())
        .toList();

    System.out.println(listArray);
  }
}
