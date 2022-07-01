package practice.designpatterns.singleton;

public class SingletonManager {
    public static void main(String args[]){
        //not working: Singleton singleton = new Singleton();
        Singleton singleton = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton == singleton2);
        System.out.println(singleton.equals(singleton2));
        singleton.setX(6);
        System.out.println(singleton.getX());
        System.out.println(singleton2.getX());
        System.out.println(singleton == singleton2);
        System.out.println(singleton.equals(singleton2));
    }
}
