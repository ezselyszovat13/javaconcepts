package practice.generics;

public class GenericManager {
    public static void main(String args[]){
        Generic<Integer> integerGeneric = new Generic<>(5);
        System.out.println(integerGeneric.getData());

        Generic<String> stringGeneric = new Generic<>("duck");
        System.out.println(stringGeneric.getData());
    }
}
