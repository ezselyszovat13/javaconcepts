package practice.collectionprac;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;

public class OwnList {
    public static void main(String args[]){
        List<Integer> arrayL = new ArrayList<>();
        arrayL.add(5);
        arrayL.add(7);
        System.out.println(arrayL.stream().findFirst().get());
        System.out.println(arrayL);

        List<Integer> linkedL = new LinkedList<>();
        linkedL.add(5);
        linkedL.add(7);
        System.out.println(linkedL.stream().findFirst().get());
        System.out.println(linkedL);

        List<Integer> synchronizedList = Collections.synchronizedList(new ArrayList<>());
        synchronizedList.add(5);
        synchronizedList.add(7);
        System.out.println(synchronizedList.stream().findFirst().get());
        System.out.println(synchronizedList);
        System.out.println(synchronizedList.contains(5));
        synchronizedList.clear();
        System.out.println(synchronizedList);
    }
}
