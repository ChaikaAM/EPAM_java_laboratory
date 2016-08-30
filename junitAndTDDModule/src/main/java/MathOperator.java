/**
 * Created by Chaika Aleksei on 22.08.2016.
 */
public class MathOperator {

    public static int getFactorial (int a){
        int result=1;
        for (int i = 0; i < a; i++) {
            result*=(i+1);
        }
        return result;
    }

    public static int multiplicate(int i1, int i2) {
        if (1l*i1*i2>Integer.MAX_VALUE ||
                1l*i1*i2 <Integer.MIN_VALUE){
            throw new RuntimeException("too large result of multiplication - " + i1*i2);
        } else return i1*i2;
    }

    public static double divide(int i1, int i2) {
        if (i2==0) throw new ArithmeticException("You cant divide by zero");
        return 1.0*i1/i2;
    }
}
