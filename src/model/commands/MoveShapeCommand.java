package model.commands;

import model.shape.Shape;
import model.util.Pair;
import model.util.ShapeList;

import java.io.IOException;

public class MoveShapeCommand implements ICommand {
    Pair start;
    Pair end;
    ShapeList master;
    ShapeList selected;

    MoveShapeCommand(Pair start, Pair end, ShapeList master, ShapeList selected) {
        this.start = start;
        this.end = end;
        this.master = master;
        this.selected = selected;
    }

    @Override
    public void run() throws IOException {
        for (Shape shape : selected) {
            int idx = master.indexOf(shape);
            Shape newShape = new Shape(start, end, shape.getShapeConfiguration());
            master.set(idx, newShape);
        }
    }
}
