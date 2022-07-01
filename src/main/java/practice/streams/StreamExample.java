package practice.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.Map;

public class StreamExample {
    public static void main(String args[]){
        Integer[] intArray = {1,2,3,4,5,6,7,8,9,10};
        List<Integer> integers = new ArrayList<>(Arrays.asList(intArray));
        List<Integer> doubled = integers.stream().map(x -> x * 2).collect(Collectors.toList());
        System.out.println(doubled);

        List<Integer> evens = integers.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        System.out.println(evens);

        List<String> words = new ArrayList<>(Arrays.asList("Ultimate", "Lame", "Interesting", "Great", "Professiona"));
        List<String> max5LetterWords = words.stream().filter(x -> x.length() <= 5).collect(Collectors.toList());
        System.out.println(max5LetterWords);

        Integer sum = integers.stream().reduce(0, Integer::sum);
        System.out.println(sum);
        Integer sum2 = integers.stream().reduce(0, (subtotal, element) -> subtotal + element);
        System.out.println(sum2);

        Long howManyShortWords = words.stream().filter(x -> x.length() <= 5).collect(Collectors.counting());
        System.out.println(howManyShortWords);

        Map<Integer, List<String>> asd = words.stream().collect(Collectors.groupingBy(
            word -> word.length()
        ));
        System.out.println(asd);
    }
}
