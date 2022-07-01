package practice.generics;

public class Generic <T> {
    private T data;

    public Generic(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
