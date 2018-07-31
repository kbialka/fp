package model.commands;

import model.Shape;
import model.interfaces.ICommand;
import util.ShapeList;

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
