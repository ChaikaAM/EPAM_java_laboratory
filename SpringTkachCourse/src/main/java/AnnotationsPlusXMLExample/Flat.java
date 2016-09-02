package AnnotationsPlusXMLExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chaika Aleksei on 01.09.2016.
 */

@Component
public class Flat {

    @Autowired
    public Room room1;
    @Autowired
    public Room room2;
    @Resource
    public Room room3;

    public Flat(){
    }

    public int getWholeArea(){
        return room1.getArea()+room2.getArea()+room3.getArea();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder()
                .append("Flat whole area - " + getWholeArea() + " m2");
        return stringBuilder.toString();
    }
}
