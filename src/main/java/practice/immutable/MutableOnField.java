package practice.immutable;

import lombok.Getter;
import lombok.Setter;
import java.util.Objects;

@Getter
@Setter
public class MutableOnField {
    private int x;

    public MutableOnField(int x) {
        this.x = x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MutableOnField that = (MutableOnField) o;
        return x == that.x;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x);
    }
}
