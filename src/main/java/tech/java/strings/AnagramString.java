package tech.java.strings;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AnagramString {

  public static void main(String[] args) {
    String str1 = "Hell0 World";
    String str2 = "0Wrdl lHeol";

    System.out.println(isAnagram2(str1, str2));

  }

  private static boolean isAnagram(String str1, String str2) {
    if (str1.length() != str2.length()) {
      return false;
    }
    Map<String, Long> subarray1 = str1.chars().mapToObj(ch -> "" + ch)
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    Map<String, Long> subarray2 = str2.chars().mapToObj(ch -> "" + ch)
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    return subarray1.equals(subarray2);
  }

  private static boolean isAnagram2(String str1, String str2) {
    if (str1.length() != str2.length()) {
      return false;
    }

    var sortedStr1 = str1.chars()
        .mapToObj(c -> (char) c)
        .sorted()
        .toList();

    var sortedStr2 = str2.chars()
        .mapToObj(c -> (char) c)
        .sorted()
        .toList();

    return sortedStr1.equals(sortedStr2);
  }
}
