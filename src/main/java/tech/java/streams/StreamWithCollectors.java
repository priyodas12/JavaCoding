package tech.java.streams;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public class StreamWithCollectors {

  public static void main (String[] args) {

    var stringList = List.of ("one", "two", "three", "four", "five",
                              "six", "seven", "eight", "nine"
                             );

    var length3Strings = stringList
        .stream ()
        .filter (s -> s.length () == 3)
        .collect (Collectors.toSet ());

    System.out.println (length3Strings);//[six, one, two]

    var stringLengthMap =
        stringList
            .stream ()
            .filter (s -> s.length () > 3)
            .collect (
                Collectors.toMap (
                    key -> key,
                    String::length
                                 ));

    System.out.println (stringLengthMap);//{nine=4, four=4, seven=5, three=5, five=4, eight=5}

    //below two pipeline will generate same output
    var lengthStringMap =
        stringList
            .stream ()
            .filter (s -> s.length () > 3)
            .collect (
                Collectors.toMap (
                    String::length,
                    key -> key,
                    (t1, t2) -> t1 + "," + t2
                                 ));
    System.out.println (lengthStringMap);//{4=four,five,nine, 5=three,seven,eight}

    var lengthStringMap2 = stringList
        .stream ()
        .collect (Collectors.groupingBy (String::length, Collectors.joining (",")));

    System.out.println (lengthStringMap2);//{3=one,two,six, 4=four,five,nine, 5=three,seven,eight}

    var toCollectionExample =
        stringList.stream ().collect (Collectors.toCollection (() -> new LinkedHashSet<> ()));

    System.out.println (
        toCollectionExample);//[eight, five, four, nine, one, seven, six, three, two]

    var countWithCollectors =
        stringList.stream ().collect (Collectors.counting ());

    System.out.println (countWithCollectors);//9

  }
}
