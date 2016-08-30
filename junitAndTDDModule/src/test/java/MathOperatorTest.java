import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Chaika Aleksei on 22.08.2016.
 */

@RunWith(Parameterized.class)
public class MathOperatorTest {

    @Parameterized.Parameters       //parametres for factorial test
    public static List<Integer[]> factorials(){
        List<Integer[]> result = new ArrayList<Integer[]>(4);
        result.add(new Integer[]{0,1});
        result.add(new Integer[]{1,1});
        result.add(new Integer[]{2,2});
        result.add(new Integer[]{3,6});
        return result;
    }
    int expected, input;
    public MathOperatorTest(int input, int expected) {
        this.expected=expected;
        this.input = input;
    }

    @Test
    public void testGetFactorial() throws Exception {
        assertEquals(expected,MathOperator.getFactorial(input));
    }

    @Test
    public void testMultiplicate() throws Exception {
        assertEquals(MathOperator.multiplicate(1,5), 1*5);
    }

    @Test(expected = RuntimeException.class)
    public void testMultiplicateException() throws Exception {
        MathOperator.multiplicate(Integer.MAX_VALUE,5);
    }

    @Test
    public void testDivide() throws Exception {
        assertEquals(MathOperator.divide(5,1), 5, 0.00001);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideException() throws Exception {
        MathOperator.divide(5,0);
    }
}