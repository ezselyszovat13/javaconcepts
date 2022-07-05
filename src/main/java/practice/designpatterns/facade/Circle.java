package practice.designpatterns.facade;

public class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
