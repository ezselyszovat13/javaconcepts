package practice.designpatterns.srp;

import java.util.Collections;

public class EmployeeService {
    public static void main(String[] args){
        Employee employee = new Employee("Jack", "Grealish");
        Employee employee2 = new Employee("Steph", "Curry");
        Employee employee3 = new Employee("Donald", "Trump");
        Employee employee4 = new Employee("Barack", "Obama");

        employee.addSubOrdinate(employee2);
        employee2.addSubOrdinate(employee3);
        employee2.addSubOrdinate(employee4);

        EmployeePrinter employeePrinter = new EmployeePrinter();
        System.out.println(employeePrinter.print(employee));
        System.out.println(employeePrinter.print(employee2));
        System.out.println(employeePrinter.print(employee3));
        System.out.println(employeePrinter.print(employee4));
    }
}
