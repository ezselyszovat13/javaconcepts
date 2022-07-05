package practice.designpatterns.composite;

import java.util.List;
import java.util.ArrayList;

public class CompanyDirectory implements Employee {
    private List<Employee> employeeList = new ArrayList<>();

    @Override
    public void showEmployeeDetails() {
        employeeList.stream().forEach(Employee::showEmployeeDetails);
    }

    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }
}
