package tech.java.strings;

public class ImmutableStr {

  public static void main(String[] args) {
    // Step 1: Create a String
    String original = "Hello";
    
    // Step 2: Try modifying the string using concatenation
    String modified = original.concat(", World!");

    // Step 3: Print both strings
    System.out.println("Original String: " + original);
    System.out.println("Modified String: " + modified);

    // Step 4: Check immutability with hashCode
    System.out.println("HashCode of Original String: " + original.hashCode());
    System.out.println("HashCode of Modified String: " + modified.hashCode());
  }
}
