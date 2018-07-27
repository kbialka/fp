package model.commands;

import model.Shape;
import model.interfaces.ICommand;
import util.ShapeList;

import java.io.IOException;

public class DrawCommand implements ICommand {
    private Shape shape;
    private ShapeList shapeList;

    public DrawCommand (Shape shape, ShapeList shapeList) {
        this.shape = shape;
        this.shapeList = shapeList;
    }

    @Override
    public void run() throws IOException {
        shapeList.add(shape);
        System.out.println(shapeList.size());
        for (Shape s: shapeList) {
            System.out.println(s.getShapeType());
        }
    }
}
