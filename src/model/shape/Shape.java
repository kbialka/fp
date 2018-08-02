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
    private ShapeConfiguration config;

    public Shape(Pair start, Pair end, ShapeConfiguration config) {
        this.start = start;
        this.end = end;
        this.primary = config.getPrimary();
        this.secondary = config.getSecondary();
        this.fill = config.getFill();
        this.shape = config.getShape();
        this.config = config;
    }

    public ShapeType getShapeType() {
        return shape;
    }

    public ShapeConfiguration getShapeConfiguration() { return config; }

    public int getX() {
        return start.getX();
    }

    public int getY() {
        return start.getY();
    }

    public int getWidth() {
        return end.getX() - start.getX();
    }

    public int getHeight() {
        return end.getY() - start.getY();
    }

    public int[] getXS() {
        // only for triangle
        int[] xs = new int[3];
        xs[0] = start.getX();
        xs[1] = xs[0];
        xs[2] = end.getX();
        return xs;
    }

    public int[] getYS() {
        // only for triangle
        int[] ys = new int[3];
        ys[0] = start.getY();
        ys[2] = end.getY();
        ys[1] = ys[2];
        return ys;
    }
}
