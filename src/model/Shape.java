package model;

import model.persistence.ShapeConfiguration;
import util.Pair;

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
}
