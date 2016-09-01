package AnnotationsExample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Chaika Aleksei on 01.09.2016.
 */

@Configuration
public class ContainerOfBeans {

    @Bean
    public Flat koroleva45(){
        return new Flat(room1(),room2(),room3());
    }

    @Bean
    public Room room1(){
        Room room = new Room();
        room.setArea(20);
        return room;
    }

    @Bean
    public Room room2(){
        Room room = new Room();
        room.setArea(10);
        return room;
    }

    @Bean
    public Room room3(){
        Room room = new Room();
        room.setArea(15);
        return room;
    }

}
