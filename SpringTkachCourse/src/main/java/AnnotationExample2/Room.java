package AnnotationExample2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Chaika Aleksei on 06.09.2016.
 */

public class Room {
    private int square;

    public void setSquare(int square) {
        this.square = square;
    }

    public int getSquare() {
        return square;
    }
}
