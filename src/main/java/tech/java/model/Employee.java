package tech.java.model;

import java.math.BigInteger;
import java.util.List;
import java.util.Set;

public class Employee {

  private final BigInteger employeeId;
  private final Double salary;
  private final String email;
  private final String department;
  private final boolean isActive;
  private final Set<String> projectSet;
  private final List<Long> phoneNumber;

  private Employee (
      Builder builder
                   ) {
    this.employeeId = builder.employeeId;
    this.salary = builder.salary;
    this.email = builder.email;
    this.department = builder.department;
    this.isActive = builder.isActive;
    this.projectSet = builder.projectSet;
    this.phoneNumber = builder.phoneNumber;
  }

  public Set<String> getProjectSet () {
    return projectSet;
  }

  public BigInteger getEmployeeId () {
    return employeeId;
  }

  public Double getSalary () {
    return salary;
  }

  public String getEmail () {
    return email;
  }

  public String getDepartment () {
    return department;
  }

  public boolean isActive () {
    return isActive;
  }

  public List<Long> getPhoneNumber () {
    return phoneNumber;
  }

  @Override
  public String toString () {
    return "Employee{" +
           "employeeId=" + employeeId +
           ", salary=" + salary +
           ", email='" + email + '\'' +
           ", department='" + department + '\'' +
           ", isActive=" + isActive +
           ", projectSet=" + projectSet +
           ", phoneNumber=" + phoneNumber +
           '}';
  }

  public static class Builder {

    private BigInteger employeeId;
    private Double salary;
    private String email;
    private String department;
    private boolean isActive;
    private Set<String> projectSet;
    private List<Long> phoneNumber;

    public Employee build () {
      return new Employee (this);
    }

    public Builder employeeId (BigInteger employeeId) {
      this.employeeId = employeeId;
      return this;
    }

    public Builder salary (Double salary) {
      this.salary = salary;
      return this;
    }

    public Builder email (String email) {
      this.email = email;
      return this;
    }

    public Builder department (String department) {
      this.department = department;
      return this;
    }

    public Builder isActive (boolean active) {
      isActive = active;
      return this;
    }

    public Builder projectSet (Set<String> projectSet) {
      this.projectSet = projectSet;
      return this;
    }

    public Builder phoneNumber (List<Long> phoneNumber) {
      this.phoneNumber = phoneNumber;
      return this;
    }
  }
}
