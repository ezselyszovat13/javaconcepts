package practice.designpatterns.ocp;

public class Car extends Vehicle {
    @Override
    public double calculateValue() {
        return this.getValue() * 0.8;
    }
}
