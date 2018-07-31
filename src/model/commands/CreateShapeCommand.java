package model.commands;

import model.shape.Shape;
import model.interfaces.ICommand;
import model.util.ShapeList;

import java.io.IOException;

public class CreateShapeCommand implements ICommand {
    private Shape shape;
    private ShapeList shapeList;

    public CreateShapeCommand(Shape shape, ShapeList shapeList) {
        this.shape = shape;
        this.shapeList = shapeList;
    }

    @Override
    public void run() throws IOException {
        shapeList.add(shape);
    }
}
