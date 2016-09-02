package AnnotationsPlusXMLExample;

import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by Chaika Aleksei on 01.09.2016.
 */


public class Realization{

    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext("SpringTkachCourse/src/main/java/AnnotationsPlusXMLExample/koroleva.xml");

        Room room = context.getBean("room1", Room.class);

        Flat flat = context.getBean(Flat.class);
        System.out.println(room);
        System.out.println(flat.room1);
        System.out.println(flat);
    }
}
