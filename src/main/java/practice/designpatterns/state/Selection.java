package practice.designpatterns.state;

public class Selection implements Tool{
    @Override
    public void mouseDown() {
        System.out.println("Selection started!");
    }

    @Override
    public void mouseUp() {
        System.out.println("Selection ended!");
    }
}
