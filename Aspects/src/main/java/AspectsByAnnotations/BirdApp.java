package AspectsByAnnotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by Chaika Aleksei on 02.09.2016.
 */
public class BirdApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext aspectinitcontext =
                new ClassPathXmlApplicationContext("aspectsinit.xml");

        Bird bird = aspectinitcontext.getBean(Bird.class);

        bird.saySomeThing();
        bird.sayWhoYouAre();
    }
}