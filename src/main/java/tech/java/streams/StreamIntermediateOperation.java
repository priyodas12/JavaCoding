package tech.java.streams;

/*Intermediate Operations
---------------------------------------
1.Find all people over a certain age from a list of Person objects.
2.Get a list of product names from a list of Product objects.
3.Find the longest string in a list of strings.
4.Partition a list of integers into odd and even numbers.
5.Get the distinct characters from a list of strings.
*/

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamIntermediateOperation {

  public static void main (String[] args) {

    //3.Find the longest string in a list of strings

    //by sorting
    var list = List.of ("abghsw", "tfg", "iow9", "1kuwi^s", "1");
    var sortedList = list.stream ().sorted (Comparator.comparing (String::length)).toList ();
    System.out.println (sortedList.getLast ());

    //by max()
    var longestString = list.stream ().max (Comparator.comparing (String::length)).orElse (null);
    System.out.println (longestString);

    //3.Find the highest number in a list of number
    var numList = List.of (1, 2, 3, 4, 5, 6, 0);
    var highestNumber = numList.stream ().max (Comparator.naturalOrder ());
    System.out.println (highestNumber.orElse (null));

    //4.Partition a list of integers into odd and even numbers.
    var partitionOddEven = numList.stream ().collect (Collectors.partitioningBy (i -> i % 2 == 0));
    System.out.println (partitionOddEven);

    //4.Partition a list of integers into prime & non prime.
    var partitionPrime = numList.stream ().collect (Collectors.partitioningBy (
        StreamIntermediateOperation::isPrime));
    System.out.println (partitionPrime);

    //5.Get the distinct characters from a list of strings.
    List<String> strList = List.of ("@pb1e", "b@nan@", "ch3rry");
    var distinctChar =
        strList.stream ().flatMapToInt (String::chars).mapToObj (value -> (char) value).collect (
            Collectors.toSet ());

    System.out.println (distinctChar);
  }

  static boolean isPrime (int i) {
    if (i < 2) {
      return false;
    }
    return IntStream.rangeClosed (2, (int) Math.sqrt (i)).noneMatch (n -> i % n == 0);
  }
}
