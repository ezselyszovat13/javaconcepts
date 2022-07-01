package practice.designpatterns.singleton;

import java.util.Objects;

public class Singleton {
    private int x;
    private static Singleton instance = null;

    private Singleton(int x) {
        this.x = x;
    }

    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton(5);
        }
        return instance;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Singleton singleton = (Singleton) o;
        return x == singleton.x;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x);
    }
}
