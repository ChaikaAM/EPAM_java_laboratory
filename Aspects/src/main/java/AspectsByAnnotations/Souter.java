package AspectsByAnnotations;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by Chaika Aleksei on 02.09.2016.
 */

@Aspect
public class Souter {

//        @Pointcut(value = "execution(* *.*())")
    @Pointcut(value = "execution(* Bird.*(..))")
    public void ololo() {

    }

    //    @Before("execution(* *.saySomeThing())")
    @Before("ololo()")
    void sayAboutBegin() {
        System.out.println("----------------------");
        System.out.println("New command started...");
    }

    @After("ololo()")
    void sayAboutEnd() {
        System.out.println("Command done!!");
    }
}