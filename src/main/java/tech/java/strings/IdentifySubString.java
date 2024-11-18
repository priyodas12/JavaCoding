package tech.java.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IdentifySubString {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    System.out.println("Enter a string: ");
    String str = scn.next();

    char[] chars = str.toCharArray();
    List<Character> currentList = new ArrayList<Character>();
    List<List<Character>> resultList = new ArrayList<>();

    getSubstrings(0, chars, currentList, resultList);

    System.out.println(resultList);
  }

  private static void getSubstrings(
      int index,
      char[] chars,
      List<Character> current,
      List<List<Character>> result) {

    result.add(new ArrayList<>(current));

    for (int i = index; i < chars.length; i++) {
      current.add(chars[i]);
      getSubstrings(i + 1, chars, current, result);
      current.removeLast();
    }
  }
}
