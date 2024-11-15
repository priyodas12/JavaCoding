package tech.java.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CryptoGenerator {

  public static void main(String[] args) {
    Map<String, String> cryptoMapSm = getCryptoCombinationMap();

    Scanner scanner = new Scanner(System.in);

    System.out.println("enter any string:");
    String input = scanner.next();
    String encodedString = getEncodedString(input);
    
    System.out.println("encoded string: " + encodedString);
  }

  private static String getEncodedString(String tobeEncoded) {
    return Arrays.stream(tobeEncoded.split("")).map(letter -> {
      return getCryptoCombinationMap().getOrDefault(letter, letter);
    }).collect(Collectors.joining());
  }

  private static Map<String, String> getCryptoCombinationMap() {
    final String origin = "qwertyuiopasdfghjklzxcvbnm";
    final String seed = "zxcvbnmasdfghjklqwertyuiop";

    List<String> originList = Arrays.stream(origin.split("")).toList();

    List<String> seedList = Arrays.stream(seed.split("")).toList();

    Map<String, String> cryptoMapSm = new HashMap<>();

    for (int i = 0; i < originList.size(); i++) {
      cryptoMapSm.put(originList.get(i), seedList.get(i));
    }
    for (int i = 0; i < originList.size(); i++) {
      cryptoMapSm.put(originList.get(i).toUpperCase(), seedList.get(i).toUpperCase());
    }
    return cryptoMapSm;
  }
}
