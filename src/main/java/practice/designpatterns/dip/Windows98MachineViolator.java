package practice.designpatterns.dip;

public class Windows98MachineViolator {
    //tightly coupled parts
    private final StandardKeyboard keyboard;
    private final StandardMonitor standardMonitor;

    public Windows98MachineViolator() {
        this.keyboard = new StandardKeyboard();
        this.standardMonitor = new StandardMonitor();
    }
}
