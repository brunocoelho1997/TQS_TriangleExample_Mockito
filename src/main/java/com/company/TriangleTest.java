package com.company;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

import static com.company.Triangle.*;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(Parameterized.class)
public class TriangleTest{

    static float midleValue = 101 ;
    private float a, b, c;
    private TriangleType res;

    public TriangleTest(float a, float b, float c, TriangleType res) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection valuesToTest() {
        return Arrays.asList(new Object[][] {
                {-2, -1, 12, TriangleType.INVALID_INPUTS},

                {midleValue, midleValue, midleValue, TriangleType.Equilateral},

                {midleValue, midleValue, MIN_VALUE, TriangleType.Isosceles},
                {midleValue, midleValue, MIN_VALUE + 1, TriangleType.Isosceles},
                {midleValue, midleValue, MAX_VALUE, TriangleType.Isosceles},
                {midleValue, midleValue, MAX_VALUE - 1, TriangleType.Isosceles},

                {midleValue, MIN_VALUE,midleValue, TriangleType.Isosceles},
                {midleValue, MIN_VALUE + 1,midleValue, TriangleType.Isosceles},
                {midleValue, MAX_VALUE,midleValue, TriangleType.Isosceles},
                {midleValue, MAX_VALUE - 1,midleValue, TriangleType.Isosceles},

                {MIN_VALUE,midleValue,midleValue, TriangleType.Isosceles},
                {MIN_VALUE + 1,midleValue,midleValue, TriangleType.Isosceles},
                {MAX_VALUE,midleValue,midleValue, TriangleType.Isosceles},
                {MAX_VALUE - 1,midleValue,midleValue, TriangleType.Isosceles}
        });
    }


    @Test
    public void testSeveral() {
        System.out.println("Testing "+a+","+b+","+c+" -> "+res);
        Triangle instance = new Triangle(a,b,c);
        assertEquals(res, instance.getType());
    }

}