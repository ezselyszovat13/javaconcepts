package practice.polymorphism;

import lombok.Getter;

@Getter
public class StorageCounter {
    private int count = 0;

    public void increase(){
        this.count++;
    }

    public void increase(int number){
        this.count += number;
    }
}
