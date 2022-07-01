package practice.designpatterns.srp;

import lombok.Getter;
import java.util.Set;
import java.util.HashSet;

@Getter
public class Employee {
    private String firstName;
    private String lastName;
    private Set<Employee> subOrdinates;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subOrdinates = new HashSet<>();
    }

    public void addSubOrdinate(Employee subordinate){
        if(!subOrdinates.contains(subordinate)){
            subOrdinates.add(subordinate);
        }
    }
    public void removeAllSubordinates(){
        subOrdinates.clear();
    }

    //violates SRP
    /*public String print() {
        return "Employee{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", subOrdinates=" + subOrdinates +
            '}';
    }*/
}
