import com.company.Triangle;
import com.company.TriangleService;
import com.company.utilspkg.TriangleType;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static com.company.utilspkg.Utils.*;


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

                {MIDDLE_VALUE, MIDDLE_VALUE, MIDDLE_VALUE, TriangleType.Equilateral},

                {MIDDLE_VALUE, MIDDLE_VALUE, MIN_VALUE, TriangleType.Isosceles},
                {MIDDLE_VALUE, MIDDLE_VALUE, MIN_VALUE + 1, TriangleType.Isosceles},
                {MIDDLE_VALUE, MIDDLE_VALUE, MAX_VALUE, TriangleType.Isosceles},
                {MIDDLE_VALUE, MIDDLE_VALUE, MAX_VALUE - 1, TriangleType.Isosceles},

                {MIDDLE_VALUE, MIN_VALUE, MIDDLE_VALUE, TriangleType.Isosceles},
                {MIDDLE_VALUE, MIN_VALUE + 1, MIDDLE_VALUE, TriangleType.Isosceles},
                {MIDDLE_VALUE, MAX_VALUE, MIDDLE_VALUE, TriangleType.Isosceles},
                {MIDDLE_VALUE, MAX_VALUE - 1, MIDDLE_VALUE, TriangleType.Isosceles},

                {MIN_VALUE, MIDDLE_VALUE, MIDDLE_VALUE, TriangleType.Isosceles},
                {MIN_VALUE + 1, MIDDLE_VALUE, MIDDLE_VALUE, TriangleType.Isosceles},
                {MAX_VALUE, MIDDLE_VALUE, MIDDLE_VALUE, TriangleType.Isosceles},
                {MAX_VALUE - 1, MIDDLE_VALUE, MIDDLE_VALUE, TriangleType.Isosceles}
        });
    }


    @Test
    public void testTriangleType() {
        System.out.println("Testing :"+a+","+b+","+c+" -> "+res);
        Triangle instance = new Triangle(a,b,c);
        //assertEquals(res, instance.getType());
        Assertions.assertEquals(res, TriangleService.getTriangleType(instance));
    }


    /*
    TODO: Precisamos de definir mais testes aqui... Misturar com o Mockito
    //Stefan:  Mais testes em que sentido?
     */


}