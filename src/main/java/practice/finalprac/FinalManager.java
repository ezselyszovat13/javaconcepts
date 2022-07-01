package practice.finalprac;

import java.math.BigDecimal;

public class FinalManager {
    private static final int AGE = 32;

    public static void main(String args[]){
        //final variable cannot be changed
        //AGE = 45;
        OverridableStudent overridableStudent = new OverridableStudent(BigDecimal.TEN);
        overridableStudent.notOverridableMethod();
        overridableStudent.overridableMethod(BigDecimal.ONE);

        OverridableStudent overridableStudent1 = new SubStudent(BigDecimal.ZERO);
        overridableStudent1.notOverridableMethod();
        overridableStudent1.overridableMethod(BigDecimal.ONE);
    }
}
