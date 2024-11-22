package tech.java.map;

import java.util.HashMap;

public class HashMapImpl {

  public static void main(String[] args) {
    HashMap map = new HashMap();
    System.out.println(map.put("key1", "value1"));
    System.out.println(map.putIfAbsent("key1", "value2"));
    System.out.println(map.size());
    System.out.println(map);

    map.computeIfAbsent("key1", k -> "value3");
    System.out.println(map);
  }

}
