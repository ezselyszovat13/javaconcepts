package practice.designpatterns.ocp;

import lombok.Getter;

@Getter
public abstract class Vehicle {
    private int value;
    public abstract double calculateValue();

    //violates OCP, because we cannot add new options without modification
    /*public double calculateValue(){
        if(this instanceof Car){
            return this.getValue() * 0.8;
        } else if (this instanceof Truck) {
            return this.getValue() * 0.5;
        }
        return 1;
    }*/
}
