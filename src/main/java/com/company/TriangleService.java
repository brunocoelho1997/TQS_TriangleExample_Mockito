package com.company;

import com.company.utilspkg.TriangleType;

import static com.company.utilspkg.Utils.MAX_VALUE;
import static com.company.utilspkg.Utils.MIN_VALUE;

public class TriangleService {




    /**
     * Returns a triangle with the id of the param
     * @param id
     * @return triangle
     */
    public Triangle findTriangleById(int id){
        throw new UnsupportedOperationException();
    }

    /**
     * Insert a new triangle in db
     * @param triangle
     * @return true if created and inserted in db with success, otherwise returns false
     */
    public boolean create(Triangle triangle){
        throw new UnsupportedOperationException();
    }


    /**
     * Returns the type of the triangle. Possible types: INVALID_INPUTS, NOT_A_TRIANGLE, Equilateral, Isosceles, Scalene
     * @param triangle
     * @return
     */

    public static TriangleType getTriangleType(Triangle triangle){

        double a = triangle.getA();
        double b = triangle.getB();
        double c = triangle.getC();

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


    /**
     * Validate all attributes of the triangle and return true if it's a valid triangle, otherwise returns false
     *
     * @param triangle
     * @return
     */
    private boolean validateTriangle(Triangle triangle){
        throw new UnsupportedOperationException();
    }
}
