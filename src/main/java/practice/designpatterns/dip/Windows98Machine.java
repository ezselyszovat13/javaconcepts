package practice.designpatterns.dip;

public class Windows98Machine {
    private final Keyboard keyboard;
    private final Monitor monitor;

    public Windows98Machine(Keyboard keyboard, Monitor monitor) {
        this.keyboard = keyboard;
        this.monitor = monitor;
    }

    public static void main(String[] args){
        Keyboard keyboard = new StandardKeyboard();
        Monitor monitor = new StandardMonitor();
        Windows98Machine windows98Machine = new Windows98Machine(keyboard, monitor);
    }
}
