package AnnotationExample2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by Chaika Aleksei on 06.09.2016.
 */

public class Flat {

    @Autowired
    Room room;

    public static void main(String[] args) {
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("SpringTkachCourse/src/main/java/AnnotationExample2/text.xml");

        System.out.println(context.getBean(Flat.class).room.getSquare());

    }
}
