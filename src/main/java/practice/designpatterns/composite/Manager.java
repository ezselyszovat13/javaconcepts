package practice.designpatterns.composite;

public class Manager implements Employee {
    private String name;
    private long empId;
    private String position;

    public Manager(long empId, String name, String position) {
        this.name = name;
        this.empId = empId;
        this.position = position;
    }

    @Override
    public void showEmployeeDetails() {
        System.out.println(empId+" " +name);
    }
}
