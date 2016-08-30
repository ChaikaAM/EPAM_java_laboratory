import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Chaika Aleksei on 23.08.2016.
 */
public class Calculator {
    public static Queue<String> getMathCommands(String string) {
        Queue<String> result = new ArrayDeque<String>();
        char[] symbs = string.toCharArray();
        String data="";
        for (int i = 0; i < symbs.length; i++) {
            if (symbs[i]=='+' || symbs[i]=='-' ||
                    symbs[i]=='/' || symbs[i]=='*' ||
                    symbs[i]=='(' || symbs[i]==')'){
                result.add(data);
                data="";
                result.add(symbs[i]+"");
            }
            if ("1234567890".contains(symbs[i]+"")){
                data+=symbs[i];
            }
            if (i==symbs.length-1) result.add(data);
        }
        return result;
    }

    public static double calculateMathCommands(Queue<String> mathCommands) {
        double result = Double.parseDouble(mathCommands.peek());
        while (!mathCommands.isEmpty()) {
            String another;
            switch (another = mathCommands.poll()){
                case "+" : result+=Double.parseDouble(mathCommands.poll());
                    break;
                case "-" : result-=Double.parseDouble(mathCommands.poll());
                    break;
                case "*" : result*=Double.parseDouble(mathCommands.poll());
                    break;
                case "/" : result/=Double.parseDouble(mathCommands.poll());
                    break;
            }
        }
        return result;
    }
}
