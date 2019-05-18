import com.company.*;
import com.company.utilspkg.TriangleType;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
public class TriangleTest {


    /*
        Test dummy object
     */
    @Test
    public void testDummyObject(){

        /*
            TODO: Tentei várias maneiras de preencher o valor do objeto dummy, com sets e
            construtores etc etc mas nao consegui não sei porque, diz que é qq de ser mock e por
            vezes dava null pointer pq efetivamente nao preenchia o objeto. Contudo funciona como o
            esparado. Apenas queria mostrra com campos no objeto se der. Até pode não dar. Exemplo disso é o
            código que está comentado em baixo que ao fazer o print do objeto ele nao retorna nada. Acho que tem a ver com as propiedades do mock.

         */

        ArrayList<Triangle> list = new ArrayList<Triangle>();

        Triangle dummy = Mockito.mock(Triangle.class);

        list.add(dummy);

        assertEquals(1, list.size()); //Objeto dummy foi adicionado,

        //System.out.println("RES: " + list.toString()); //mas se quisermos verificar o valor dele é nulo claro porque nao foi preenchido com valores.


        //Não retirar, foi uma conclusao que cheguei sobre mock que tenho de falar contigo!
        //System.out.println("--------------------------------------------------------");
        //TriangleBuilder triangleBuilder = Mockito.mock(TriangleBuilder.class);
        //triangleBuilder.prepareTriangle(2,2,2);
        //System.out.println("RES: " + triangleBuilder.toString());
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

        System.out.println("Triangle 1 type:" + triangleService.getTriangleType(spyList.get(0)) + "\n");
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

        //System.out.println("Triangle type:" + triangleService.getTriangleType(mockList.get(1)));
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
        Triangle mockedTriangle = Mockito.mock(Triangle.class);
        Mockito.when(mockedTriangle.getA()).thenReturn(5.0);
        Mockito.when(mockedTriangle.getB()).thenReturn(5.0);
        Mockito.when(mockedTriangle.getC()).thenReturn(5.0);

        System.out.println("Mocked Triangle: " + mockedTriangle);
        System.out.println("Mocked Triangle - A: " + mockedTriangle.getA());
        System.out.println("Mocked Triangle - B: " + mockedTriangle.getB());
        System.out.println("Mocked Triangle - C: " + mockedTriangle.getC());
        System.out.println("Mocked Triangle - Type: " + TriangleService.getTriangleType(mockedTriangle));
        System.out.println("-----------------");
    }

    /*
        Test fake object
     */
    @Test
    public void testFakeObject(){

        TriangleService triangleService = new TriangleService();

        System.out.println("Test findTriangleById");
        Triangle invalidInputsTriangle = triangleService.findTriangleById(1);
        System.out.println(invalidInputsTriangle);
        Assertions.assertEquals(TriangleType.INVALID_INPUTS, TriangleService.getTriangleType(invalidInputsTriangle));

        Triangle equilateralTriangle = triangleService.findTriangleById(2);
        System.out.println(equilateralTriangle);
        assertEquals(TriangleType.Equilateral, TriangleService.getTriangleType(equilateralTriangle));

        Triangle isoscelesTriangle = triangleService.findTriangleById(3);
        System.out.println(isoscelesTriangle);
        assertEquals(TriangleType.Isosceles, TriangleService.getTriangleType(isoscelesTriangle));

        System.out.println("Test create & findTriangleById");

        Triangle triangleTmp = new Triangle(1,2,3);
        triangleService.create(triangleTmp);

        triangleTmp = null;

        //assumindo que sabemos que ele vai ter o ID = 5
        triangleTmp = triangleService.findTriangleById(5);
        System.out.println(triangleTmp);
        assertEquals(TriangleType.NOT_A_TRIANGLE, TriangleService.getTriangleType(triangleTmp));

    }

    /*
        Test captor
     */
    @Mock
    List mockedList;

    @Captor
    ArgumentCaptor<Triangle> argCaptor;
 
    @Test
    public void testCaptor(){

        Triangle test = new Triangle(2,2,2);

        mockedList.add(test);

        Mockito.verify(mockedList).add(argCaptor.capture());

        assertEquals(test, argCaptor.getValue());

        System.out.println("Argumento capturado: " + argCaptor.getValue());

    }

    /*
        Test inject mocks
     */
    @InjectMocks
    TriangleService triangleServiceInjectMocks;

    /*
    se colocarmos comentarios este TriangleFileManager como comentario
    (que por sua vez esta entro da classe TriangleService)
    vai dar nullPointerException
     */
    //@Mock
    TriangleFileManager fileManager;

    @Test
    public void testInjectMocks() {
        Triangle testTriangle = new Triangle(2, 2, 2);
        boolean saved = triangleServiceInjectMocks.saveOnTxtFile(testTriangle);
        assertEquals(true, saved);
    }

    /*
    @InjectMocks //cria uma instância da classe e injeta os mocks criados com @Mock ou @Spy
    Triangle triangle = new Triangle(1,2,2,2);

    @Mock
    TriangleService triangleService = new TriangleService();

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testInjectMocks(){
        Triangle testTriangle = new Triangle(2,2,2,2);

        boolean getType = triangle.getTriangleType(testTriangle);
        assertEquals(true, getType);
    }
    */


    /*
        Test BDD Mockito
     */
    @Test
    public void testBDDMockito(){

        System.out.println("-----------------------");
        System.out.println("------Test BDD Mockito------");


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
        Test Mockito limitations
     */
    @Test
    public void testMockitoLimitations(){

        //Mocking a constructor
        //Mockito.when(new Triangle(1,2,3,4)).thenReturn(new Triangle(1,2,3,4));

        //Mocking static methods
        Triangle triangle = new Triangle(100, 2);
        //Mockito.when(TriangleService.getTriangleType(triangle)).thenReturn(TriangleType.Equilateral);


        Triangle triangleA = new Triangle(1,2,3,4);
        Triangle triangleB = new Triangle(1,2,3,4);
        //Mockito.when(triangleA.equals(triangleB)).thenReturn(true);

        //imaginando que queriamos ter um método que validasse todos os campos de um trianglo, caso este estivesse tudo bem retornava true
        Triangle triangleC = new Triangle(1,2,3,4);
        TriangleService triangleService = new TriangleService();
        //Mockito.when(triangleService.validateTriangle(triangle)).thenReturn(true);
    }

}
