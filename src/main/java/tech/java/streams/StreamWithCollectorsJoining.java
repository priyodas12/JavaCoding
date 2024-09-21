package tech.java.streams;

import java.util.List;
import java.util.stream.Collectors;

public class StreamWithCollectorsJoining {

  public static void main (String[] args) {
    var stringList = List.of (
        "one", "two", "three", "four", "five", "six", "seven", "eight", "nine");

    var joiningString1 = stringList.stream ().collect (Collectors.joining ());

    System.out.println (joiningString1);//onetwothreefourfivesixseveneightnine

    var joiningString2 = stringList.stream ().collect (Collectors.joining ("_"));

    System.out.println (joiningString2);//one_two_three_four_five_six_seven_eight_nine
  }
}
