package model.shape;

import model.persistence.ShapeConfiguration;
import model.shape.featureEnums.ShapeColor;
import model.shape.featureEnums.ShapeShadingType;
import model.shape.featureEnums.ShapeType;
import model.util.Pair;

public class Shape {
    private Pair start;
    private Pair end;
    private ShapeColor primary;
    private ShapeColor secondary;
    private ShapeShadingType fill;
    private ShapeType shape;

    public Shape(Pair start, Pair end, ShapeConfiguration config) {
        this.start = start;
        this.end = end;
        this.primary = config.getPrimary();
        this.secondary = config.getSecondary();
        this.fill = config.getFill();
        this.shape = config.getShape();
    }

    public ShapeType getShapeType() {
        return shape;
    }

    public int getX() {
        return Math.min(start.getX(), end.getX());
    }

    public int getY() {
        return Math.min(start.getY(), end.getY());
    }

    public int getWidth() {
        return Math.abs(start.getX() - end.getX());
    }

    public int getHeight() {
        return Math.abs(start.getY() - end.getY());
    }

    public int[] getXS() {
        // only for triangle
        int[] xs = new int[3];
        xs[0] = Math.min(start.getX(), end.getX());
        xs[1] = xs[0];
        xs[2] = Math.max(start.getX(), end.getX());
        return xs;
    }

    public int[] getYS() {
        // only for triangle
        int[] ys = new int[3];
        ys[0] = Math.min(start.getY(), end.getY());
        ys[2] = Math.max(start.getY(), end.getY());
        ys[1] = ys[2];
        return ys;
    }
}
