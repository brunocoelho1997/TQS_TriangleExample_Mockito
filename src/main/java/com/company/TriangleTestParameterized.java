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
public class TriangleTestParameterized {

    int id;
    private float a, b, c;
    private TriangleType res;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    public TriangleTestParameterized(float a, float b, float c, TriangleType res) {
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


    /*
    TODO: Precisamos de definir mais testes aqui... Misturar com o Mockito
     */


}