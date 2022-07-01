package practice.immutable;

import java.util.ArrayList;
import java.util.Arrays;

public class MutabilityManager {
    public static void main(String args[]){
        MutableOnField mutableOnField = new MutableOnField(5);
        MutableOnField mutableOnFieldModified = new MutableOnField(5);
        mutableOnFieldModified.setX(6);
        System.out.println(mutableOnField.equals(mutableOnFieldModified));

        ImmutableEasy immutableEasy = new ImmutableEasy(6, new ArrayList<>(Arrays.asList(1,2,3,4,5)));
    }
}
