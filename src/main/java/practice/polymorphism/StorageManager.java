package practice.polymorphism;

public class StorageManager {
    public static void main(String args[]){
        StorageCounter storageCounter = new StorageCounter();
        System.out.println(storageCounter.getCount());
        storageCounter.increase();
        System.out.println(storageCounter.getCount());
        storageCounter.increase(5);
        System.out.println(storageCounter.getCount());
    }
}
