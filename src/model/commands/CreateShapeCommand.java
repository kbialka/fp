package model.commands;

import model.shape.Shape;
import model.util.ShapeList;

import java.io.IOException;

class CreateShapeCommand implements ICommand, IUndoable {
    private Shape shape;
    private ShapeList shapeList;

    CreateShapeCommand(Shape shape, ShapeList shapeList) {
        this.shape = shape;
        this.shapeList = shapeList;
    }

    @Override
    public void run() throws IOException {
        shapeList.add(shape);
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        shapeList.remove(shape);
    }

    @Override
    public void redo() {
        shapeList.add(shape);
    }
}
