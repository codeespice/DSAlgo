package com.g.prepare.fractions;

public class Fraction {

    int numerator;
    int denominator;

    public Fraction(int numerator,int denominator)
    {
        if(denominator==0)
        {
            throw new IllegalArgumentException("cannot devide by zero");
        }
        this.numerator=numerator;
        this.denominator=denominator;
        reduce();

    }
    private void reduce()
    {
        int gcd = calculateGCD(numerator,denominator);
        numerator = numerator/gcd;
        denominator = denominator/gcd;
    }

    private int calculateGCD(int numerator,int denominator)
    {
        if(denominator==0)
        {
            return numerator;
        }
        else
        {
            return calculateGCD(denominator,numerator%denominator);
        }


    }

    public Fraction add(Fraction fraction)
    {
        int denominator = this.denominator*fraction.denominator;
        int numerator = this.numerator*fraction.denominator+fraction.numerator*this.denominator;
        return new Fraction(numerator,denominator);
    }
    public Fraction subtract(Fraction fraction)
    {
        int denominator = this.denominator*fraction.denominator;
        int numerator = this.numerator*fraction.denominator-fraction.numerator*this.denominator;
        return new Fraction(numerator,denominator);
    }
    public Fraction multiplication(Fraction fraction)
    {
        int denominator = this.denominator*fraction.denominator;
        int numerator = this.numerator*fraction.numerator;
        return new Fraction(numerator,denominator);
    }
    public Fraction division(Fraction fraction)
    {
        int denominator = this.denominator*fraction.numerator;
        int numerator = this.numerator*fraction.denominator;
        return new Fraction(numerator,denominator);
    }
    @Override
    public String toString() {
        return "Fraction{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }
}
