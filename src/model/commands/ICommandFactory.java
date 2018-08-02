package model.commands;

import model.persistence.ShapeConfiguration;
import model.shape.Shape;
import model.util.Pair;
import model.util.ShapeList;

public class ICommandFactory {
    private ICommandFactory() {}

    public static ICommand createShapeCommand(Pair start, Pair end, ShapeConfiguration config, ShapeList shapeList) {
        return new CreateShapeCommand(new Shape(start, end, config), shapeList);
    }

    public static ICommand createSelectCommand(Pair start, Pair end, ShapeList master, ShapeList selected) {
        return new SelectShapeCommand(start, end, master, selected);
    }
}
