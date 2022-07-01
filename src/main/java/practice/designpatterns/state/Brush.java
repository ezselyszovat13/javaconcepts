package practice.designpatterns.state;

public class Brush implements Tool {
    @Override
    public void mouseDown() {
        System.out.println("Painting started!");
    }

    @Override
    public void mouseUp() {
        System.out.println("Painting ended!");
    }
}
