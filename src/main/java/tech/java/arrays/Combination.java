package tech.java.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Combination {

  public static void main (String[] args) {
    var list = Arrays.asList (0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

    var finalResultCombinations = new ArrayList<List<Integer>> ();

    var permutationResults = new ArrayList<List<Integer>> ();

    generateCombinations (list, 0, 4, new ArrayList<> (), finalResultCombinations);

    Permutations.generatePermutations (list, 0, permutationResults);

    Set<String> partialSet = new HashSet<> ();

    for (int i = 0; i < 5; i++) {

      permutationResults.get (i).forEach (j -> {
        var set = finalResultCombinations.stream ()
            .map (a -> a.stream ()
                .map (String::valueOf)
                .collect (Collectors.joining ("")))
            .collect (Collectors.toSet ());
        partialSet.addAll (set);
      });

    }
  /*  finalResultCombinations.stream ()
        .map (a -> a.stream ()
            .map (String::valueOf)
            .collect (Collectors.joining ("")))
        .collect (Collectors.toSet ()).forEach (System.out::println);
*/
    System.out.println (partialSet.size ());

    //System.out.println (factorialOf (10) / (factorialOf (10 - 4)));
  }

  private static void generateCombinations (
      List<Integer> integerList,
      int index,
      int combinationSize,
      List<Integer> currentCombination,
      List<List<Integer>> finalResult
                                           ) {

    if (currentCombination.size () == combinationSize) {
      finalResult.add (new ArrayList<> (currentCombination));
    }

    for (int i = index; i < integerList.size (); i++) {
      currentCombination.add (integerList.get (i));

      generateCombinations (
          integerList,
          index + 1,
          combinationSize,
          currentCombination,
          finalResult
                           );

      currentCombination.removeLast ();
    }
  }

  private static int factorialOf (int num) {
    if (num <= 0) {
      return 1;
    }
    return num * factorialOf (num - 1);
  }
}
