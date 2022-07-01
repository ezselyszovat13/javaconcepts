package practice.copying;

import java.math.BigDecimal;

public class StudentManager {
    public static void main(String args[]) throws CloneNotSupportedException {
        Student student1 = new Student("Brian", BigDecimal.valueOf(18));
        //will point to the same reference
        Student student2 = student1;
        //will be different object
        Student student3 = student1.clone();
        System.out.println(student1.equals(student2));
        System.out.println(student1.equals(student3));
        System.out.println(student1 == student2);
        System.out.println(student1 != student3);
    }
}
