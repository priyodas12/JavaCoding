package tech.java.classloader;

import java.util.Arrays;

/**
 * The class-loading mechanism still follows the same general steps (loading, linking,
 * initializing), but it now deals with modules instead of a single JAR:
 * <p>
 * Bootstrap ClassLoader: Loads core modules (like java.base). Instead of loading from rt.jar, it
 * loads from the module graph, where each module describes its contents.
 * <p>
 * Platform ClassLoader: Loads additional modules (like java.logging and java.sql). Handles classes
 * from other standard modules provided by the JDK.
 * <p>
 * <p>
 * Application ClassLoader:Loads user-defined classes. Loads classes from the application's
 * classpath or from custom modules.
 */
public class ClassLoadImpl {

  // Since java.util.ArrayList is part of the java.base module,
  // it is loaded by the Bootstrap ClassLoader, which is why the output is null.
  public static void main (String[] args) {
    try {

      //by bootstrap class loader
      Class<?> arrayListClass = Class.forName ("java.util.ArrayList");
      Class<?> stringClass = String.class;
      //by platform class loader
      Class<?> driverClass = Class.forName ("java.sql.Driver");
      //application classloader
      Class<?> customClass = Class.forName ("tech.java.classloader.TestClass");

      System.out.println ("ArrayList loaded by: "
                          + arrayListClass.getClassLoader ());
      System.out.println ("String loaded by: "
                          + stringClass.getClassLoader ());

      System.out.println ("Driver loaded by: "
                          + driverClass.getClassLoader ().getName ());

      System.out.println ("Custom loaded by: "
                          + customClass.getClassLoader ().getName ());

      System.out.println (Arrays.toString (customClass.getConstructors ()));
      System.out.println ((customClass.getModifiers ()));
      System.out.println ((Arrays.toString (customClass.getFields ())));
    }
    catch (ClassNotFoundException e) {
      System.out.println ("Exception:: " + e.getMessage ());
    }
  }
}
