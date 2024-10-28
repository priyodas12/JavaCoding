package tech.java.model;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class EmployeeUtils {

  public static List<Employee> getEmployee () {
    Employee e1 = new Employee.Builder ()
        .employeeId (BigInteger.valueOf (29392421))
        .salary (95000.7700)
        .email ("bohn.doe21@example.com")
        .department ("Engineering")
        .isActive (false)
        .projectSet (new HashSet<> (Arrays.asList ("Project A", "Project B")))
        .phoneNumber (Arrays.asList (1244567890L, 5876573210L))
        .build ();
    Employee e2 = new Employee.Builder ()
        .employeeId (BigInteger.valueOf (776854431))
        .salary (581000.500)
        .email ("roxx.doe@example.com")
        .department ("Accounts")
        .isActive (true)
        .projectSet (new HashSet<> (Arrays.asList ("Project A", "Project V")))
        .phoneNumber (Arrays.asList (2234567890L, 987652610L))
        .build ();
    Employee e3 = new Employee.Builder ()
        .employeeId (BigInteger.valueOf (22324321))
        .salary (925000.70)
        .email ("hugo.doe@example.com")
        .department ("HR")
        .isActive (true)
        .projectSet (new HashSet<> (Arrays.asList ("Project F", "Project X")))
        .phoneNumber (Arrays.asList (8234567890L, 9893654210L))
        .build ();
    Employee e4 = new Employee.Builder ()
        .employeeId (BigInteger.valueOf (1232326))
        .salary (5823000.90)
        .email ("Lohae.doe@example.com")
        .department ("R&D")
        .isActive (false)
        .projectSet (new HashSet<> (Arrays.asList ("Project A", "Project B")))
        .phoneNumber (Arrays.asList (4234567890L, 9896543210L))
        .build ();
    Employee e5 = new Employee.Builder ()
        .employeeId (BigInteger.valueOf (232112123))
        .salary (525000.4230)
        .email ("ntws.do2e@example.com")
        .department ("Sales")
        .isActive (true)
        .projectSet (new HashSet<> (Arrays.asList ("Project A", "Project E")))
        .phoneNumber (Arrays.asList (7234567890L, 6876543210L))
        .build ();

    Employee e12 = new Employee.Builder ()
        .employeeId (BigInteger.valueOf (29392421))
        .salary (959000.7700)
        .email ("htsiw.doe21@example.com")
        .department ("Engineering")
        .isActive (false)
        .projectSet (new HashSet<> (Arrays.asList ("Project A", "Project B")))
        .phoneNumber (Arrays.asList (1244567890L, 5876573210L))
        .build ();
    Employee e22 = new Employee.Builder ()
        .employeeId (BigInteger.valueOf (776854431))
        .salary (781000.500)
        .email ("njus.doe@example.com")
        .department ("Accounts")
        .isActive (true)
        .projectSet (new HashSet<> (Arrays.asList ("Project M", "Project B")))
        .phoneNumber (Arrays.asList (2234567890L, 987652610L))
        .build ();
    Employee e23 = new Employee.Builder ()
        .employeeId (BigInteger.valueOf (642324321))
        .salary (125000.70)
        .email ("ko1hn.doe@example.com")
        .department ("HR")
        .isActive (true)
        .projectSet (new HashSet<> (Arrays.asList ("Project H", "Project K")))
        .phoneNumber (Arrays.asList (8234567890L, 9893654210L))
        .build ();
    Employee e24 = new Employee.Builder ()
        .employeeId (BigInteger.valueOf (1232326))
        .salary (25000.90)
        .email ("lo2hn.doe@example.com")
        .department ("R&D")
        .isActive (false)
        .projectSet (new HashSet<> (Arrays.asList ("Project A", "Project D")))
        .phoneNumber (Arrays.asList (4234567890L, 9896543210L))
        .build ();
    Employee e25 = new Employee.Builder ()
        .employeeId (BigInteger.valueOf (232112123))
        .salary (925000.4230)
        .email ("qohn.do2e@example.com")
        .department ("Sales")
        .isActive (true)
        .projectSet (new HashSet<> (Arrays.asList ("Project X", "Project Y")))
        .phoneNumber (Arrays.asList (7234567890L, 6876543210L))
        .build ();
    return Arrays.asList (e1, e12, e23, e25, e24, e3, e4, e5, e22, e2);
  }
}
