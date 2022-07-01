package practice.immutable;

import lombok.Getter;
import java.util.List;

@Getter
public final class ImmutableEasy {
    private final int x;
    private final List<Integer> marks;

    public ImmutableEasy(int x, List<Integer> marks) {
        this.x = x;
        this.marks = marks;
    }
}
