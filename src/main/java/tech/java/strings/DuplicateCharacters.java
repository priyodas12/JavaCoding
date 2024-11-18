package tech.java.strings;

import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateCharacters {

  public static void main(String[] args) {
    String str = "amsterdam to london t";

    var chars = str.replace(" ", "").chars()
        .mapToObj(ch -> (char) ch)
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    var duplcates = chars.keySet().stream().filter(ch -> chars.get(ch) > 1).toList();

    System.out.println(duplcates);
  }

}
