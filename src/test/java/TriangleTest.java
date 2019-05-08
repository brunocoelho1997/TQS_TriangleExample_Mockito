import com.company.*;
import com.company.utilspkg.TriangleType;
import com.sun.xml.internal.bind.v2.TODO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleTest {


    /*
        Test dummy object
     */
    @Test
    public void testDummyObject(){

        TriangleService triangleService = new TriangleService();

        //Sem Instanciar
        Triangle dummyTriangle = Mockito.mock(Triangle.class);

        ArrayList<Triangle> list = new ArrayList<Triangle>();

        list.add(dummyTriangle);
        //list.add(new Triangle(2,2,2));
        System.out.println("Resultado EX1: " + list.toString());

        assertEquals(1, list.size());

        System.out.println("Triangle type:" + triangleService.getTriangleType(list.get(0)));


        //Instaciar
        Triangle dummyTriangle2 = Mockito.mock(Triangle.class);

        ArrayList<Triangle> list2 = new ArrayList<Triangle>();

        //list2.add(dummyTriangle);
        list2.add(new Triangle(2,2,2));
        System.out.println("Resultado EX2: " + list2.toString());

        assertEquals(1, list2.size());

        System.out.println("Triangle type:" + triangleService.getTriangleType(list2.get(0)));
    }

    /*
        Test spy object
     */

    @Spy
     ArrayList<Triangle> triangleList = Mockito.spy(new ArrayList<Triangle>());

    @Test
    public void testSpyObject(){

        TriangleService triangleService = new TriangleService();


        Triangle triangle = new Triangle(2,2,2);

        triangleList.add(triangle);

        Mockito.verify(triangleList).add(new Triangle(2,2,2));

        assertEquals(1, triangleList.size());

        System.out.println("Triangle type:" + triangleService.getTriangleType(triangleList.get(0)));

//-------------------------------------------------------------------------

        //Outro exemplo
        ArrayList<Triangle> list = new ArrayList<Triangle>();
        ArrayList<Triangle> spyList = Mockito.spy(list);


        spyList.add(new Triangle(2,2,2));
        spyList.add(new Triangle(2,3,2));

        Mockito.verify(spyList).add(new Triangle(2,2,2));
        Mockito.verify(spyList).add(new Triangle(2,3,2));

        assertEquals(2, spyList.size());

        System.out.println("Triangle 1 type:" + triangleService.getTriangleType(spyList.get(0)));
        System.out.println("Triangle 2 type:" + triangleService.getTriangleType(spyList.get(1)));
    }
    //TODO: Ambos os casos de estudo estão a dar argumentos diferentes ao correr o codigo, não esotu a conseguir perceber porque ou o que estou a fazer de errado xD

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

        System.out.println("-----------------");
        System.out.println("-Test sub object-");

        //Example 1:
        System.out.println("Example 1:");
        TriangleBuilder triangleBuilder = Mockito.mock(TriangleBuilder.class);

        triangleBuilder.prepareTriangle(-2.0,-1.0,12.0);
        Mockito.when(triangleBuilder.build()).thenReturn(new Triangle(-2, -1, 12));

        System.out.println("Triangle returned by TriangleBuilder: " + triangleBuilder.build());

        //Example 2:
        System.out.println("\nExample 2:");
        TriangleService triangleService = new TriangleService();
        Triangle mockedTriangle = Mockito.mock(Triangle.class);
        Mockito.when(mockedTriangle.getA()).thenReturn(5.0);
        Mockito.when(mockedTriangle.getB()).thenReturn(5.0);
        Mockito.when(mockedTriangle.getC()).thenReturn(5.0);

        System.out.println("Mocked Triangle: " + mockedTriangle);
        System.out.println("Mocked Triangle - A: " + mockedTriangle.getA());
        System.out.println("Mocked Triangle - B: " + mockedTriangle.getB());
        System.out.println("Mocked Triangle - C: " + mockedTriangle.getC());
        System.out.println("Mocked Triangle - Type: " + triangleService.getTriangleType(mockedTriangle));
        System.out.println("-----------------");

    }

    /*
        Test sub object
     */
    @Test
    public void testFakeObject(){

        TriangleService triangleService = new TriangleService();
        FakeTriangleRepository fakeTriangleRepository = new FakeTriangleRepository();

        Triangle invalidInputsTriangle = fakeTriangleRepository.findTriangleById(1);
        System.out.println(invalidInputsTriangle);
        Assertions.assertEquals(TriangleType.INVALID_INPUTS, triangleService.getTriangleType(invalidInputsTriangle));

        Triangle equilateralTriangle = fakeTriangleRepository.findTriangleById(2);
        System.out.println(equilateralTriangle);
        assertEquals(TriangleType.Equilateral, triangleService.getTriangleType(equilateralTriangle));

        Triangle isoscelesTriangle = fakeTriangleRepository.findTriangleById(3);
        System.out.println(isoscelesTriangle);
        assertEquals(TriangleType.Isosceles, triangleService.getTriangleType(isoscelesTriangle));

        Triangle notTriangle = fakeTriangleRepository.findTriangleById(4);
        assertEquals(TriangleType.Scalene, triangleService.getTriangleType(notTriangle));

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

        System.out.println("-----------------");
        System.out.println("-Test sub object-");


        FakeTriangleRepository fakeTriangleRepository = new FakeTriangleRepository();

        FakeTriangleRepository fakeTriangleRepositorySpy = Mockito.spy(fakeTriangleRepository);

        Triangle xptoTriangle = new Triangle(1221, 4.0, 5.0, 3.0);

        Mockito.when(fakeTriangleRepositorySpy.findTriangleById(1221)).thenReturn(null);

        fakeTriangleRepositorySpy.create(xptoTriangle);

        Mockito.verify(fakeTriangleRepositorySpy).findTriangleById(1221);


        //Without BDD Mockito:
        System.out.println("Without BDD Mockito:");





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
