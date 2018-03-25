package com.g.prepare.fractions;

public class FractionsValidate {
    public static void main(String args[])
    {
        Fraction f1 = new Fraction(20,35);
        Fraction f2 = new Fraction(27,45);
        Fraction f3 = new Fraction(8,20);

        System.out.println("addition::"+f1.add(f2));
        System.out.println("subtraction::"+f1.subtract(f2));
        System.out.println("multiplication::"+f1.multiplication(f2));
        System.out.println("division::"+f1.division(f2));
    }
}
