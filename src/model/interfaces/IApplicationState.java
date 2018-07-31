package model.interfaces;

import model.shape.featureEnums.ShapeColor;
import model.shape.featureEnums.ShapeShadingType;
import model.shape.featureEnums.ShapeType;
import model.shape.featureEnums.StartAndEndPointMode;
import model.persistence.ShapeConfiguration;

public interface IApplicationState {
    void setActiveShape();

    void setActivePrimaryColor();

    void setActiveSecondaryColor();

    void setActiveShadingType();

    void setActiveStartAndEndPointMode();

    ShapeType getActiveShapeType();

    ShapeColor getActivePrimaryColor();

    ShapeColor getActiveSecondaryColor();

    ShapeShadingType getActiveShapeShadingType();

    StartAndEndPointMode getActiveStartAndEndPointMode();

    ShapeConfiguration getCurrentConfiguration();
}
