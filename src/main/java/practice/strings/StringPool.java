package practice.strings;

public class StringPool {
    public static void main(String args[]){
        //using it as literal, we can search for it in a String pool
        String animal = "duck";
        //Using new will always create a new entry to the pool even if it contains the exact string
        String car = new String("Audi");
        String secondAnimal = "duck";
        String secondCar = new String("Audi");
        System.out.println(animal == secondAnimal);
        System.out.println(car == secondCar);
    }
}
