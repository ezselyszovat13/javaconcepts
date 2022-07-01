package practice.designpatterns.ocp;

public class Truck extends Vehicle {
    @Override
    public double calculateValue() {
        return this.getValue() * 0.5;
    }
}
