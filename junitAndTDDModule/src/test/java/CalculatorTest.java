import org.junit.Test;

import java.util.Queue;

/**
 * Created by Chaika Aleksei on 23.08.2016.
 */
public class CalculatorTest {

    String string = "35+12";

    @Test
    public void parseStringToMathCommands(){
        Queue<String> mathCommands = Calculator.getMathCommands(string);
        System.out.println(mathCommands);
    }

    @Test
    public void calculateMathCommands(){
        double result = Calculator.calculateMathCommands(Calculator.getMathCommands(string));
        System.out.println(result);
    }
}
