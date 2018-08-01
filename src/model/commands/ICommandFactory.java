package model.commands;

import model.persistence.ShapeConfiguration;
import model.shape.Shape;
import model.util.Pair;
import model.util.ShapeList;

public class ICommandFactory {
    private ICommandFactory() {}

    public static ICommand createShapeCommand(Pair start, Pair end,
                                              ShapeConfiguration config, ShapeList shapeList) {
        return new CreateShapeCommand(new Shape(start, end, config), shapeList);
    }
}
