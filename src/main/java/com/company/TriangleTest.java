package com.company;

import org.junit.Test;
import org.mockito.Mockito;

import static com.company.Utils.*;
import static com.company.Utils.middleValue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleTest {


    /*
        Test dummy object
     */
    @Test
    public void testDummyObject(){

    }

    /*
        Test spy object
     */
    @Test
    public void testSpyObject(){

    }

    /*
        Test mock object
     */
    @Test
    public void testMockObject(){

    }

    /*
        Test sub object
     */
    @Test
    public void testStubObject(){

    }

    /*
        Test sub object
     */
    @Test
    public void testFakeObject(){

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

    /*
        Test captor
     */
    @Test
    public void testCaptor(){

    }

    /*
        Test inject mocks
     */
    @Test
    public void testInjectMocks(){

    }

    /*
        Test BDD Mockito
     */
    @Test
    public void testBDDMockito(){

    }

}
