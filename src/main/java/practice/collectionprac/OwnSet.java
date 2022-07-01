package practice.collectionprac;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class OwnSet {

    @Getter
    @AllArgsConstructor
    public static class OwnInteger {
        private int x;

        @Override
        public String toString() {
            return "OwnInteger{" +
                "x=" + x +
                '}';
        }

        //without this, 5 and 5 would be different
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            OwnInteger that = (OwnInteger) o;
            return x == that.x;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x);
        }
    }



    public static void main(String args[]){
        Set<Integer> integers = new HashSet<>();
        integers.add(7);
        integers.add(5);
        integers.add(5);
        System.out.println(integers.stream().findFirst().get());
        System.out.println(integers);

        Set<OwnInteger> ownIntegers = new HashSet<>();
        ownIntegers.add(new OwnInteger(5));
        ownIntegers.add(new OwnInteger(5));
        ownIntegers.add(new OwnInteger(7));
        ownIntegers.add(null);
        System.out.println(ownIntegers);

        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(7);
        treeSet.add(5);
        System.out.println(treeSet.stream().findFirst().get());
        System.out.println(treeSet);
        System.out.println(treeSet.contains(5));
        treeSet.clear();
        System.out.println(treeSet);
    }
}
