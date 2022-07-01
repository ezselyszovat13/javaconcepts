package practice.accessmodifiers;

import lombok.Getter;

@Getter
public class Sub extends Base{
    private int v;

    public void printAvailableVariables(){
        System.out.println(
            String.format(
                "W is package-private, but I am in the same package: %d\n" +
                    "X is not private, I can only ask by getter: %d\n" +
                    "Y is protected, I can reach it since I am descendant: %d\n" +
                    "Z is public, so everyone can reach it: %d",
                w, super.getX(), y, z)
        );
    }
}
