package AnnotationsExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.Resource;

/**
 * Created by Chaika Aleksei on 01.09.2016.
 */


public class Realization{

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ContainerOfBeans.class);
        context.refresh();

        Flat bean = context.getBean(Flat.class);
        Room room = context.getBean("room1",Room.class);

        System.out.println(bean);
        System.out.println(room);
    }
}
