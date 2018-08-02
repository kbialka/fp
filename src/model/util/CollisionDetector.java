package model.util;

import model.shape.Shape;

public class CollisionDetector {

    public static Boolean detect(Pair start, Pair end, Shape shape) {
        if ( (start.getX() < shape.getX()) && (start.getY() < shape.getY())
                && (end.getX() > shape.getX() + shape.getWidth())
                && (end.getY() > shape.getY() + shape.getHeight())) {
            return true;
        } else {
            return false;
        }
    }
}
