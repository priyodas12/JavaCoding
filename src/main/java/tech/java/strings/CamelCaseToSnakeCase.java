package tech.java.strings;

public class CamelCaseToSnakeCase {

  public static void main(String[] args) {
    String input = "MakeMyTrip";
    
    String snakeCase = input.replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase();

    System.out.println("snake_case: " + snakeCase);
  }
}
