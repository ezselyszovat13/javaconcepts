package practice.designpatterns.observer;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Subject {
    private final List<Observer> observers = new ArrayList<>();
    private int state;

    public void setState(int state){
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObservers(){
        observers.stream().forEach(Observer::update);
    }
}
