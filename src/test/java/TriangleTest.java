import com.company.*;
import com.company.utilspkg.TriangleType;
import com.sun.xml.internal.bind.v2.TODO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;

import java.lang.reflect.Array;
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
        //triangleService.sendTriangle(triangleList.get(0));

        Mockito.verify(triangleList).add(triangle);
        //Mockito.verify(triangleService, times()).sendTriangle(triangleList.get(0));

        assertEquals(1, triangleList.size());

        System.out.println("Triangle type:" + triangleService.getTriangleType(triangleList.get(0)));
        System.out.println("--------------------------------------------------------");

//-------------------------------------------------------------------------

        //Outro exemplo
        ArrayList<Triangle> list = new ArrayList<Triangle>();

        ArrayList<Triangle> spyList = Mockito.spy(list);

        Triangle triangle2 = new Triangle(2,3,2);
        spyList.add(triangle2);

        Mockito.verify(spyList).add(triangle2);

        assertEquals(1, spyList.size());
        assertEquals(0, list.size());

        System.out.println("Triangle 1 type:" + triangleService.getTriangleType(spyList.get(0)));
        System.out.println("SIZE original list:" + list.size());//lista original permanece igual
        System.out.println("SIZE spy list:" + spyList.size());//spy list é alterada

    }

    /*
        Test mock object
     */

    @Test
    public void testMockObject(){
        TriangleService triangleService = new TriangleService();

        ArrayList<Triangle> mockList = Mockito.mock(ArrayList.class);

        Triangle triangle = new Triangle(2,3,2);

        mockList.add(triangle);
        //TODO: Queria aqui usar o when para enriquecer isto mas não me está a ocorrer como :c
        //Mockito.when(mockList.add(triangle)).thenReturn();
        Mockito.verify(mockList).add(triangle);

        assertEquals(0, mockList.size());//Aqui está  adiferença entre o mock e spy, o mock não adiciona nada, apenas chama o metodo sem nenhum efeito colateral, ao contrario do spy que ele realmente chama a implementacao real do metodo add e adiciona o elemento a lista

        System.out.println("Triangle type:" + triangleService.getTriangleType(mockList.get(0)));
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
        System.out.println("-Test BDD Mockito-");


        System.out.println("-Without BDD Mockito-");

        ArrayList<Triangle> triangleListMocked = Mockito.mock(ArrayList.class);
        //Quando pedir o tamanho do arrayList deverá indicar que é 0
        Mockito.when(triangleListMocked.size()).thenReturn(0);
        System.out.println("triangleList.size(): " + triangleListMocked.size());

        //cria um triangulo e insere no array
        Triangle triangle = new Triangle(2,2,2);
        triangleListMocked.add(triangle);

        //verifica se o método add foi chamado e com este triangulo
        Mockito.verify(triangleListMocked).add(triangle);

        //---------------------------------------------------------------------------------
        System.out.println("-With BDD Mockito-");
        triangleListMocked = Mockito.mock(ArrayList.class);
        //Quando pedir o tamanho do arrayList deverá indicar que é 0
        BDDMockito.given(triangleListMocked.size()).willReturn(0);
        System.out.println("triangleList.size(): " + triangleListMocked.size());

        //cria um triangulo e insere no array
        triangle = new Triangle(2,2,2);
        triangleListMocked.add(triangle);

        //verifica se o método add foi chamado e com este triangulo
        BDDMockito.then(triangleListMocked).should().add(triangle);


        //exemplo de erro
        //BDDMockito.then(triangleListMocked).should().remove(triangle);

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
