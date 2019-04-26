package com.company;

public class Triangle {

    public static float MAX_VALUE = 200;
    public static float MIN_VALUE = 1;

    private float a,b,c;

    public Triangle(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }


    public TriangleType getType(){


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

    public void setA(float a) {
        this.a = a;
    }

    public float getB() {
        return b;
    }

    public void setB(float b) {
        this.b = b;
    }

    public float getC() {
        return c;
    }

    public void setC(float c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
