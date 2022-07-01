package practice.finalprac;

import lombok.Getter;
import java.math.BigDecimal;

@Getter
public final class Student {
    private final BigDecimal id;

    public Student(BigDecimal id) {
        this.id = id;
    }
}
