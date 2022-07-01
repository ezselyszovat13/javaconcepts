package practice.finalprac;

import java.math.BigDecimal;

//final class cannot be extended
public class SubStudent /*extends Student*/ extends OverridableStudent {
    public SubStudent(BigDecimal id) {
        super(id);
    }

    @Override
    protected void overridableMethod(final BigDecimal id) {
        //final parameter variable cannot be changed
        //id = BigDecimal.ONE;
        System.out.println("SUB METHOD " + id);
    }

    //final methods cannot be overriden
    /*@Override
    public void notOverridableMethod(){

    }*/
}
