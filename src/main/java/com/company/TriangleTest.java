package com.company;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static com.company.Utils.*;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(Parameterized.class)
public class TriangleTest{

    int id;
    private float a, b, c;
    private TriangleType res;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

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

                {middleValue, middleValue, middleValue, TriangleType.Equilateral},

                {middleValue, middleValue, MIN_VALUE, TriangleType.Isosceles},
                {middleValue, middleValue, MIN_VALUE + 1, TriangleType.Isosceles},
                {middleValue, middleValue, MAX_VALUE, TriangleType.Isosceles},
                {middleValue, middleValue, MAX_VALUE - 1, TriangleType.Isosceles},

                {middleValue, MIN_VALUE,middleValue, TriangleType.Isosceles},
                {middleValue, MIN_VALUE + 1,middleValue, TriangleType.Isosceles},
                {middleValue, MAX_VALUE,middleValue, TriangleType.Isosceles},
                {middleValue, MAX_VALUE - 1,middleValue, TriangleType.Isosceles},

                {MIN_VALUE,middleValue,middleValue, TriangleType.Isosceles},
                {MIN_VALUE + 1,middleValue,middleValue, TriangleType.Isosceles},
                {MAX_VALUE,middleValue,middleValue, TriangleType.Isosceles},
                {MAX_VALUE - 1,middleValue,middleValue, TriangleType.Isosceles}
        });
    }


    @Test
    public void testTriangleType() {
        System.out.println("Testing :"+a+","+b+","+c+" -> "+res);
        Triangle instance = new Triangle(a,b,c);
        //assertEquals(res, instance.getType());
        assertEquals(res, TriangleService.getTriangleType(instance));
    }

    @Test
    public void testFindTriangleById(){

        TriangleService triangleService = Mockito.mock(TriangleService.class);

        Mockito.when(triangleService.findTriangleById(1)).thenReturn(new Triangle(-2, -1, 12));
        Mockito.when(triangleService.findTriangleById(2)).thenReturn(new Triangle(1,1,1));
        Mockito.when(triangleService.findTriangleById(3)).thenReturn(new Triangle(middleValue, MIN_VALUE,middleValue));
        Mockito.when(triangleService.findTriangleById(4)).thenReturn(new Triangle(MAX_VALUE - 1,middleValue,middleValue + 1));



        Triangle invalidInputsTriangle = triangleService.findTriangleById(1);
        assertEquals(TriangleType.INVALID_INPUTS, TriangleService.getTriangleType(invalidInputsTriangle));

        Triangle equilateralTriangle = triangleService.findTriangleById(2);
        assertEquals(TriangleType.Equilateral, TriangleService.getTriangleType(equilateralTriangle));

        Triangle isoscelesTriangle = triangleService.findTriangleById(3);
        assertEquals(TriangleType.Isosceles, TriangleService.getTriangleType(isoscelesTriangle));

        /*

        Triangle notTriangle = triangleService.findTriangleById(4);
        assertEquals(TriangleType.NOT_A_TRIANGLE, TriangleService.getTriangleType(notTriangle));
 */


    }

}