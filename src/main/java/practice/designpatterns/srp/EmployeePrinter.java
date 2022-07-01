package practice.designpatterns.srp;

public class EmployeePrinter {
    public String print(Employee employee) {
        return "Employee{" +
            "firstName='" + employee.getFirstName() + '\'' +
            ", lastName='" + employee.getLastName() + '\'' +
            ", subOrdinates=" + employee.getSubOrdinates() +
            '}';
    }
}
