package AnnotationsExample;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chaika Aleksei on 01.09.2016.
 */


public class Flat {

    private List<Room> rooms = new ArrayList<>();

    public Flat(Room... rooms) {
        for (Room room: rooms) {
            this.rooms.add(room);
        }
    }

    public int getWholeArea(){
        int result=0;
        for (int i = 0; i < rooms.size(); i++) {
            result+=rooms.get(i).getArea();
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder()
                .append("Flat has "+rooms.size()+" rooms.")
                .append("Whole area - " + getWholeArea() + " m2");
        return stringBuilder.toString();
    }
}
