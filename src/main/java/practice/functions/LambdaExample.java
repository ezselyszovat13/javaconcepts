package practice.functions;

import java.util.function.Function;
import java.util.function.BiFunction;

public class LambdaExample {

    public static interface NoArgFunction<R> {
        R apply();
    }

    public static void main(String args[]){
        Function<Integer, Integer> myTriple = number -> number * 3;
        System.out.println(myTriple.apply(5));

        Function<String, Integer> getStringLength = string -> string.length();
        System.out.println(getStringLength.apply("A kacsa kicsi."));

        BiFunction<Integer, Integer, Integer> add = (x,y) -> x + y;
        System.out.println(add.apply(5,7));

        NoArgFunction<String> sayHello = () -> "Hello!";
        sayHello.apply();
    }
}
