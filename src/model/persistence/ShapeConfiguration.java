package model.persistence;

import model.shape.featureEnums.ShapeColor;
import model.shape.featureEnums.ShapeShadingType;
import model.shape.featureEnums.ShapeType;

public class ShapeConfiguration {
    private ShapeColor primary;
    private ShapeColor secondary;
    private ShapeShadingType fill;
    private ShapeType shape;

    ShapeConfiguration(ShapeColor primary, ShapeColor secondary, ShapeShadingType fill, ShapeType shape) {
        this.primary = primary;
        this.secondary = secondary;
        this.fill = fill;
        this.shape = shape;
    }

    public ShapeColor getPrimary() {
        return primary;
    }

    public ShapeColor getSecondary() {
        return secondary;
    }

    public ShapeShadingType getFill() {
        return fill;
    }

    public ShapeType getShape() {
        return shape;
    }
}
