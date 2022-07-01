package practice.accessmodifiers;

public class Manager {
    public static void main(String args[]){
        Base accessModifier = new Sub();
        accessModifier.printAvailableVariables();
    }
}
