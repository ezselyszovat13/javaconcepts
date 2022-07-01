package practice.accessmodifiers;

import lombok.Getter;

@Getter
public abstract class Base {
    int w = 1;
    private int x = 2;
    protected int y = 3;
    public int z = 4;

    public abstract void printAvailableVariables();
}
