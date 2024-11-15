package tech.java.streams.operations;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import tech.java.streams.model.Employee;


public class CollectorsGrouping {

  public static void main(String[] args) {

    var listOfCrypto = List.of("USDC", "SOL", "ETH", "BTC", "DOGE", "SBIH", "LTC", "YTR", "BYG",
        "EGT", "BTC");

    /*groupBy: duplicate string into map*/
    Map<String, Long> grp1 = listOfCrypto.stream()
        .collect(Collectors
            .groupingBy(Function.identity(), Collectors.counting()));

    System.out.println(grp1);

    /*groupBy: grouping crypto by first character*/
    Map<String, List<String>> grp2 = listOfCrypto.stream()
        .collect(Collectors
            .groupingBy(crypto -> String.valueOf(crypto.charAt(0)), Collectors.toList()));

    System.out.println(grp2);

    /*groupBy: grouping by length of string*/
    Map<Integer, List<String>> grp3 = listOfCrypto.stream()
        .collect(Collectors
            .groupingBy(String::length, Collectors.toList()));

    System.out.println(grp3);

    /*groupBy: grouping by department name and prints those names*/
    Map<String, List<String>> groupedByDepartment = getEmployees().stream()
        .collect(
            Collectors.groupingBy(Employee::department,
                Collectors.mapping(Employee::empName, Collectors.toList())
            ));
    System.out.println(groupedByDepartment);
  }

  private static List<Employee> getEmployees() {
    List<Employee> employees = new ArrayList<>();

    employees.add(new Employee(102, "test1", "IT"));
    employees.add(new Employee(80, "test9", "ENGG"));
    employees.add(new Employee(135, "test2", "HR"));
    employees.add(new Employee(181, "test3", "SALES"));
    employees.add(new Employee(918, "test4", "DEVOPS"));
    employees.add(new Employee(132, "test5", "ENGG"));
    employees.add(new Employee(132, "test7", "TECHOPS"));
    employees.add(new Employee(132, "test22", "TECHOPS"));

    return employees;
  }
}
