package com.company;

import static com.company.Utils.MAX_VALUE;
import static com.company.Utils.MIN_VALUE;

public class TriangleService {

    public Triangle findTriangleById(int id){

        //todo: we need return the triangle with the id
        return null;

    }


    public static TriangleType getTriangleType(Triangle triangle){

        float a = triangle.getA();
        float b = triangle.getB();
        float c = triangle.getC();


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
}
