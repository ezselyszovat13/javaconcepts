package practice.polymorphism;

public class AnimalManager {
    public static void main(String[] args){
        Animal dog = new Dog();
        dog.animalSound();

        Animal pig = new Pig();
        pig.animalSound();
    }
}
