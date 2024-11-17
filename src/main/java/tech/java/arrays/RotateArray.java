package tech.java.arrays;

import java.util.stream.IntStream;

public class RotateArray {

  public static void main(String[] args) {
    var arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    var reverseArr = IntStream.range(0, arr.length)
        .map(i -> arr[arr.length - i - 1])
        .toArray();


  }

}
