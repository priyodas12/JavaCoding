package tech.java.streams;

import java.util.Comparator;
import java.util.List;

import tech.java.model.Employee;
import tech.java.model.EmployeeUtils;

/*
1.Sort a list of employees by salary.
2.Check if any string in a list has more than 5 characters.
3.Find the second smallest number in a list of integers.
4.Skip the first 5 elements in a list and then find the sum of the remaining elements.
5.Get the average age from a list of Person objects.*/
public class StreamWithObject {

  public static void main (String[] args) {

    var empList = EmployeeUtils.getEmployee ();
    //1.Sort a list of employees by salary.
    empList.stream ()
        .sorted (Comparator.comparing (Employee::getSalary))
        .sorted (Comparator.comparing (Employee::getDepartment))
        .forEach (System.out::println);

    //2.find second-smallest number in list
    var numList = List.of (1, 2, 3, 4, 5, 6, 0);
    var secSmallest = numList.stream ()
        .distinct ()
        .sorted ()
        .skip (1)
        .findFirst ()
        .orElse (null);

    System.out.println (secSmallest);

    //2.find second-highest number in list
    var secHighest = numList.stream ()
        .distinct ()
        .sorted (Comparator.reverseOrder ())
        .skip (1)
        .findFirst ()
        .orElse (null);

    System.out.println (secHighest);
  }
}
