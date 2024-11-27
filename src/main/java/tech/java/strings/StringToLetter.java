package tech.java.strings;

import java.util.ArrayList;
import java.util.List;

public class StringToLetter {

  public static void main(String[] args) {
    String str = "Hello World";
    String noSpaces = str.replaceAll("\\s", "");
    List<String> listOfWord = new ArrayList<String>();
    //non-functional approach
    for (char c : noSpaces.toCharArray()) {
      listOfWord.add(String.valueOf(c));
    }

    System.out.println(listOfWord);

    var charList = noSpaces.chars().mapToObj(c -> (char) c + "").toList();

    System.out.println(charList);
  }

}
