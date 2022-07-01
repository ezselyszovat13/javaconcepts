package practice.collectionprac;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class OwnMap {
    public static void main(String args[]){
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "two");
        map.put(1, "one");
        System.out.println(map.containsKey(1));
        System.out.println(map.containsValue("one"));
        System.out.println(map.containsValue("three"));
        System.out.println(map.entrySet());
        System.out.println(map.values());
        System.out.println(map.keySet());
        System.out.println(map.isEmpty());
        map.replace(1,"ván");
        System.out.println(map.entrySet());
        map.clear();
        System.out.println(map.isEmpty());
        map.replace(1,"ván");
        System.out.println(map.entrySet());

        Map<Integer, String> map2 = new TreeMap<>();
        map2.put(2, "two");
        map2.put(1, "one");
        System.out.println(map2.containsKey(1));
        System.out.println(map2.containsValue("one"));
        System.out.println(map2.containsValue("three"));
        System.out.println(map2.entrySet());
        System.out.println(map2.values());
        System.out.println(map2.keySet());
        System.out.println(map2.isEmpty());
        map2.replace(1,"ván");
        System.out.println(map2.entrySet());
        map2.clear();
        System.out.println(map2.isEmpty());
        map2.replace(1,"ván");
        System.out.println(map2.entrySet());

        map.put(2, "two");
        map.put(1, "one");
        map2.put(2, "two");
        map2.put(1, "one");

        for(Map.Entry<Integer, String> element : map.entrySet()){
            System.out.println(element.getKey() + " " + element.getValue());
        }

        for(Map.Entry<Integer, String> element : map2.entrySet()){
            System.out.println(element.getKey() + " " + element.getValue());
        }
    }
}
