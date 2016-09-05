package AspectsByAnnotations;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by Chaika Aleksei on 02.09.2016.
 */

@Component(value = "kakadu")
public class Bird{

    @Value("Kakadu")
    private String name;

    @Value("Krokoko")
    private String myspeach;

    public void sayWhoYouAre(){
        System.out.println("I am " + name);
    }

    public void saySomeThing(){
        System.out.println(name + " says : " + myspeach);
    }
}
