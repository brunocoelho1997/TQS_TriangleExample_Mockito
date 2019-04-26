package com.company;

import static com.company.Utils.MAX_VALUE;
import static com.company.Utils.MIN_VALUE;

public class Triangle {

    private int id;
    private float a,b,c;

    public Triangle(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public TriangleType getTriangleType(){
        //validate sizes
        if(a > MAX_VALUE || b > MAX_VALUE || c > MAX_VALUE)
            return TriangleType.INVALID_INPUTS;
        if(a < MIN_VALUE || b < MIN_VALUE || c < MIN_VALUE)
            return TriangleType.INVALID_INPUTS;

        //verify laterals
        if(!(a < (b + c)))
            return TriangleType.NOT_A_TRIANGLE;
        if(!(b < (a + c)))
            return TriangleType.NOT_A_TRIANGLE;
        if(!(c < (a + b)))
            return TriangleType.NOT_A_TRIANGLE;

        //if is an equilateral
        if(a == b && a == c && b == c)
            return TriangleType.Equilateral;

        //if is an isosceles
        if(a == b && b != c)
            return TriangleType.Isosceles;

        if(a != b && b == c)
            return TriangleType.Isosceles;

        if(a != b && c == a)
            return TriangleType.Isosceles;

        return TriangleType.Scalene;
    }

    public float getA() {
        return a;
    }

    public float getB() {
        return b;
    }

    public float getC() {
        return c;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "id=" + id +
                ", a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}