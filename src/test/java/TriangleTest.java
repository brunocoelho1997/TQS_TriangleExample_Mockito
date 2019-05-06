import com.company.*;
import com.company.utilspkg.TriangleType;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

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

        TriangleBuilder triangleBuilder = Mockito.mock(TriangleBuilder.class);

        //Example 1:
        triangleBuilder.prepareTriangle(-2.0,-1.0,12.0);
        Mockito.when(triangleBuilder.build()).thenReturn(new Triangle(-2, -1, 12));

        //Example 2:

        //assertEquals(TriangleType.Equilateral, TriangleService.getTriangleType(equilateralTriangle));


    }

    /*
        Test sub object
     */
    @Test
    public void testFakeObject(){

        FakeTriangleRepository fakeTriangleRepository = new FakeTriangleRepository();

        Triangle invalidInputsTriangle = fakeTriangleRepository.findTriangleById(1);
        System.out.println(invalidInputsTriangle);
        Assertions.assertEquals(TriangleType.INVALID_INPUTS, TriangleService.getTriangleType(invalidInputsTriangle));

        Triangle equilateralTriangle = fakeTriangleRepository.findTriangleById(2);
        System.out.println(equilateralTriangle);
        assertEquals(TriangleType.Equilateral, TriangleService.getTriangleType(equilateralTriangle));

        Triangle isoscelesTriangle = fakeTriangleRepository.findTriangleById(3);
        System.out.println(isoscelesTriangle);
        assertEquals(TriangleType.Isosceles, TriangleService.getTriangleType(isoscelesTriangle));

        Triangle notTriangle = fakeTriangleRepository.findTriangleById(4);
        assertEquals(TriangleType.Scalene, TriangleService.getTriangleType(notTriangle));

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

    /*

    @Test
    public void exampleTest(){

        TriangleService triangleService = Mockito.mock(TriangleService.class);

        Mockito.when(triangleService.findTriangleById(1)).thenReturn(new Triangle(-2, -1, 12));
        Mockito.when(triangleService.findTriangleById(2)).thenReturn(new Triangle(1,1,1));
        Mockito.when(triangleService.findTriangleById(3)).thenReturn(new Triangle(MIDDLE_VALUE, MIN_VALUE, MIDDLE_VALUE));
        Mockito.when(triangleService.findTriangleById(4)).thenReturn(new Triangle(MAX_VALUE - 1, MIDDLE_VALUE, MIDDLE_VALUE + 1));



        Triangle invalidInputsTriangle = triangleService.findTriangleById(1);
        assertEquals(TriangleType.INVALID_INPUTS, TriangleService.getTriangleType(invalidInputsTriangle));

        Triangle equilateralTriangle = triangleService.findTriangleById(2);
        assertEquals(TriangleType.Equilateral, TriangleService.getTriangleType(equilateralTriangle));

        Triangle isoscelesTriangle = triangleService.findTriangleById(3);
        assertEquals(TriangleType.Isosceles, TriangleService.getTriangleType(isoscelesTriangle));


        Triangle notTriangle = triangleService.findTriangleById(4);
        assertEquals(TriangleType.Scalene, TriangleService.getTriangleType(notTriangle));

    }
    */

}
