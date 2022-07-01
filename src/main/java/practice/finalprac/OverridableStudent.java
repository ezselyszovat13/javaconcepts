package practice.finalprac;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class OverridableStudent {
    private final BigDecimal id;

    protected void overridableMethod(final BigDecimal id){
        System.out.println("BASE METHOD");
    }

    public final void notOverridableMethod(){
        System.out.println("NOT OVERRIDABLE BASE METHOD");
    }
}
