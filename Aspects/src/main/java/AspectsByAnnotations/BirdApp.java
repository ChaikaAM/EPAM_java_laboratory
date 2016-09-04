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
        FileSystemXmlApplicationContext aspectinitcontext =
                new FileSystemXmlApplicationContext("Aspects/src/main/java/AspectsByAnnotations/aspectsinit.xml");

        Bird bean = aspectinitcontext.getBean(Bird.class);

        bean.saySomeThing();
        bean.sayWhoYouAre();


    }
}